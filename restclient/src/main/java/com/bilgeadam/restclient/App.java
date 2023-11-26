package com.bilgeadam.restclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	private static RestTemplate template;

	public static void main(String[] args) {
		template = new RestTemplate();
		ResponseErrorHandler handler = new ResponseErrorHandler() {

			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				System.out.println(response.getStatusCode());
				if (response.getStatusCode().is4xxClientError()) {
					if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
						System.err.println("Kayıt bulunamadı, geçerli kayıt giriniz.");
					} else {
					}
				} else if (response.getStatusCode().is5xxServerError()) {
					System.err.println("Sunucu hatası");
					// Burada gerekirse istediğiniz işlemleri yapabilirsiniz.
				}
				return false;
			}

			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				System.err.println("handle error kısmı");
			}
		};

		template.setErrorHandler(handler);
//		getByIDEntity();
//		getByIdExchange();
//		deleteExample();
//		getAll();
		postExample();
	}

	//bunu header tipinde yaptım çünkü entity yapsı generic yapmam gerekirdi kimisi ogretmen kimisi void
	public static HttpHeaders login() {
		String url = "http://127.0.0.1:8080/login";
		SystemUser user = new SystemUser("user", "1234");
		HttpEntity<SystemUser> tokenbody = new HttpEntity<SystemUser>(user);
		ResponseEntity<TokenInfo> tokenresponse = template.postForEntity(url, tokenbody, TokenInfo.class);
		TokenInfo tokenInfo = tokenresponse.getBody();
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", tokenInfo.getToken());
		return header;
	}

	// Dışardaki exceptiondaki mesaj
//	private static void getByIDEntity() {
//		String url = "http://127.0.0.1:8080/ogretmen/getbyid/{id}";
//		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
//		uriVariables.put("id", 200);
//		// Burada response body içindeki measjı göstermek için <String> dedik. Böylece
//		// response bodysine ulaştık. Ayrıca response status code da gösterilir.
//		ResponseEntity<String> response = template.getForEntity(url, String.class, uriVariables);
//		ObjectMapper objectMapper = new ObjectMapper();
//		try {
//			Ogretmen ogretmen = objectMapper.readValue(response.getBody(), Ogretmen.class);
//			System.out.println(ogretmen);
//		} catch (JsonMappingException e) {
//			System.err.println(response.getBody());
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			System.err.println(response.getBody());
//			e.printStackTrace();
//		}
//
//	}

	// global exceptiondan tokenlı 2 tane status code yazıyor biri login
	private static void getByIDEntity() {
		HttpHeaders authToken = login();
		
		String url = "http://127.0.0.1:8080/ogretmen/getbyid/{id}";
		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", 200);
		// Burada response body içindeki measjı göstermek için <String> dedik. Böylece
		// response bodysine ulaştık. Ayrıca response status code da gösterilir.
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, new HttpEntity<>(authToken), String.class, uriVariables);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Ogretmen ogretmen = objectMapper.readValue(response.getBody(), Ogretmen.class);
			System.out.println(ogretmen);
		} catch (JsonMappingException e) {
			System.err.println(response.getBody());
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			System.err.println(response.getBody());
			e.printStackTrace();
		}

	}

	// Üstteki handlerda yazan mesaj tokenlı loginli
//	private static void getByIDEntity() {
//		HttpHeaders authToken = login();
//		String url = "http://127.0.0.1:8080/ogretmen/getbyid/{id}";
//		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
//		uriVariables.put("id", 2);
//		ResponseEntity<Ogretmen> response = template.exchange(url, HttpMethod.GET, new HttpEntity<>(authToken), Ogretmen.class,
//				uriVariables);
//		System.err.println(response.getBody());
//	}

	// hocanın yazdığı kod
//	private static void getByIDEntity()
//	{
//		String url = "http://127.0.0.1:8080/ogretmen/getbyid/{id}";
//		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
//		uriVariables.put("id", 32);
//		ResponseEntity<Ogretmen> response = template.getForEntity(url, Ogretmen.class, uriVariables);
//		System.err.println(response.getStatusCode());
//		if (response.getBody() != null && response.getStatusCode().value() != 404)
//		{
//			System.err.println(response.getBody().getNAME());
//		}
//	}

	private static void getByIdExchange() {
		HttpHeaders authToken = login();
		
		String url = "http://localhost:8080/ogretmen/getbyidqueryparam?id={id}";
		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", 200);
		ResponseEntity<String> entity = template.exchange(url, HttpMethod.GET, new HttpEntity<>(authToken), String.class, uriVariables);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Ogretmen ogretmen = objectMapper.readValue(entity.getBody(), Ogretmen.class);
			System.out.println(ogretmen);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.err.println(ogretmen.getNAME() + " - " + ogretmen.getID());
	}

	// bunun alttakinden farkı gloabal exceptiondan hata mesajını gösteriyor catchin
	// içine string bodysini göstererek. Altakki ise has erroda hanle ediliyor.
//	private static void getByIdExchange()
//	{
//		String url = "http://localhost:8080/ogretmen/getbyidqueryparam?id={id}";
//		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
//		uriVariables.put("id", 200);
//		//hata altta oluyor aslında string şeklinde onu ogretmen tipinde json çevirirken hata veriyor parselanamadı diye. 
//		//Ben oraya kayıt yok diyorum çünkü empty data access fırlattığı için burada.
//		//normalde ogretmen tipinde olsaydı bu tipe hata mesajı atamayacağı için patlar has errora girerdi.Ama stringte patlamıyor json olan ogretmen nesnesini string alabiliyor mesaj zaten string. bu altta stringi ogretmene dönüştürürken patlıyor.
//		ResponseEntity<String> entity = template.exchange(url, HttpMethod.GET, null, String.class, uriVariables);		
////		System.out.println(entity.getBody()); // buraya yazmamamın sebebi hem stringken dönüyor hem jsonken ondan dolayı hata mesajını catche taşıdım.
//		ObjectMapper objectMapper = new ObjectMapper();
//		Ogretmen ogretmen;
//		try {
//			ogretmen = objectMapper.readValue(entity.getBody(), Ogretmen.class);
//			System.out.println(ogretmen);
//		} catch (JsonProcessingException e) {
//			// Burda da aslında json çevrilmeden önceki string response hata olarak yazılıyor. Farketmez srting veya json hata mesajı için hem yukarda olsaydı 200 iken 2 kere bir string bir json dönecekti.
//			System.out.println(entity.getBody()+" gardas");
//			e.printStackTrace();
//		}
//	}

	// hocanın yazdığı kod
//	private static void getByIdExchange() {
//		String url = "http://localhost:8080/ogretmen/getbyidqueryparam?id={id}";
//		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
//		uriVariables.put("id", 2);
//		ResponseEntity<Ogretmen> entity = template.exchange(url, HttpMethod.GET, null, Ogretmen.class, uriVariables);
//		Ogretmen ogretmen = entity.getBody();
//		System.err.println(ogretmen.getNAME() + " - " + ogretmen.getID());
//	}

//	private static void deleteExample() {
//		String url = "http://localhost:8080/ogretmen/deletebyid/{id}";
//		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
//		uriVariables.put("id", 390);
//		ResponseEntity<String> response = null;
//		response = template.exchange(url, HttpMethod.DELETE, null, String.class, uriVariables);
//		System.out.println(response.getBody());
//	}
	
	//loginli hocanın dediği gibi authenticate olmazsa token gerekmese de patlıyor verify olayında
	private static void deleteExample() {
		HttpHeaders authToken = login();
		
		String url = "http://localhost:8080/ogretmen/deletebyid/{id}";
		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", 37);
		ResponseEntity<String> response =template.exchange(url, HttpMethod.DELETE, new HttpEntity<>(authToken),String.class ,uriVariables);
		System.out.println(response.getBody());
	}

//	private static void getAll() {
//		String url = "http://127.0.0.1:8080/ogretmen/getalll";
//		ResponseEntity<String> response = template.getForEntity(url, String.class);
//		ObjectMapper objectMapper = new ObjectMapper();
//		try {
//			// JSON'u List<Ogretmen> formatına çevirme
//			List<Ogretmen> ogretmenList = objectMapper.readValue(response.getBody().toString(),
//					new TypeReference<List<Ogretmen>>() {
//					});
//			for (Ogretmen ogretmen : ogretmenList) {
//				System.out.println(ogretmen);
//			}
//		} catch (JsonProcessingException e) {
//			System.out.println(response.getBody());
//			e.printStackTrace();
//		}
//	}

	private static void getAll() {
		HttpHeaders authToken = login();
		
		String url = "http://127.0.0.1:8080/ogretmen/getall";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, new HttpEntity<>(authToken), String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// JSON'u List<Ogretmen> formatına çevirme
			List<Ogretmen> ogretmenList = objectMapper.readValue(response.getBody().toString(),
					new TypeReference<List<Ogretmen>>() {
					});
			for (Ogretmen ogretmen : ogretmenList) {
				System.out.println(ogretmen);
			}
		} catch (JsonProcessingException e) {
			System.out.println(response.getBody());
			e.printStackTrace();
		}
	}

//	private static void getAll()
//	{
//		String url = "http://127.0.0.1:8080/ogretmen/getall";
//		ResponseEntity<Ogretmen[]> response = template.getForEntity(url, Ogretmen[].class);
//		Ogretmen[] return_array = response.getBody();
//		List<Ogretmen> liste = Arrays.asList(return_array);
//		//System.err.println(liste.getClass());
//		for (Ogretmen ogretmen : liste)
//		{
//			System.err.println(ogretmen);
//		}
//	}

	private static void postExample() {
		HttpHeaders authToken = login();
		String url = "http://localhost:8080/ogretmen/save";
		// Jackson2ObjectMapperBuilder // gibi bir sınınf olabilir
		Ogretmen ogretmen = new Ogretmen("Deneme 666", true);
		HttpEntity<Ogretmen> body = new HttpEntity<Ogretmen>(ogretmen,authToken);
		ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, body, String.class);
		// ResponseEntity<String> response2 = template.exchange(URI.create(url),
		// HttpMethod.POST, body, String.class);
		System.err.println(response.getBody());
	}

//	private static void postExample() {
//		String url = "http://localhost:8080/ogretmen/save";
//		// Jackson20bjectMapperBuilder // gibi bir sınıf olabilir
//		Ogretmen ogretmen = new Ogretmen("Deneme3",true);
//		HttpHeaders header = new HttpHeaders();
//		header.add("Authorization", "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyLVJPTEVfVVNFUiIsImV4cCI6MTcwMDc4MDMxNH0.Mu1YnpxDAvGk8YJ_PrTQeJJYp8L-yhN2sdVIAJSF7Unk-xpKD-OD_EVTf3A5oKT_88704f4_jArIYnCNcPV1TA");
//		HttpEntity<Ogretmen> body = new HttpEntity<Ogretmen>(ogretmen,header);
//		ResponseEntity<String> response = template.postForEntity(url, body, String.class);
//		System.out.println(response.getBody());
//	}

}