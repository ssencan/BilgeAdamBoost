package com.bilgeadam.restclient;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public class App {

	private static RestTemplate template;

	public static void main(String[] args) {
		template = new RestTemplate();
		ResponseErrorHandler handler = new ResponseErrorHandler() {

			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				System.out.println(response.getStatusCode());
				if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
					// System.err.println("has error kısmı");
					return true;
				} else {
					return false;
				}

			}

			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				// System.err.println("handle error kısmı");

			}
		};

		template.setErrorHandler(handler);
//		getByIDEntity();
//		getByIdExchange();
//		deleteExample();
//		getAll();
//		postExample();
	}

	private static void getByIDEntity() {
		String url = "http://127.0.0.1:8080/ogretmen/getbyid/{id}";
		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", 200);
		// Burada response body içindeki measjı göstermek için <String> dedik. Böylece
		// response bodysine ulaştık. Ayrıca response status code da gösterilir.
		ResponseEntity<String> response = template.getForEntity(url, String.class, uriVariables);
		System.err.println(response.getBody());
//		System.err.println(response.getStatusCode());
//		if (response.getBody() != null && response.getStatusCode().value() != 404)
//		{
//			System.err.println(response.getBody().getNAME);
		// buradaki getname ne gerek var? mantığı ne?
		// Response entity tipini öğretmen yapmamızın sebei var mı?
//		}

	}
	
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
		String url = "http://localhost:8080/ogretmen/getbyidqueryparam?id={id}";
		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", 200);
		ResponseEntity<String> entity = template.exchange(url, HttpMethod.GET, null, String.class, uriVariables);
		System.out.println(entity.getBody());
		// System.err.println(ogretmen.getNAME() + " - " + ogretmen.getID());
	}

//	private static void getByIdExchange()
//	{
//		String url = "http://localhost:8080/ogretmen/getbyidqueryparam?id={id}";
//		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
//		uriVariables.put("id", 2);
//		ResponseEntity<Ogretmen> entity = template.exchange(url, HttpMethod.GET, null, Ogretmen.class, uriVariables);
//		Ogretmen ogretmen = entity.getBody();
//		System.err.println(ogretmen.getNAME() + " - " + ogretmen.getID());
//	}

	private static void deleteExample() {
		String url = "http://localhost:8080/ogretmen/deletebyid/{id}";
		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
		uriVariables.put("id", 30);
		ResponseEntity<String> response = null;
		response = template.exchange(url, HttpMethod.DELETE, null, String.class, uriVariables);
		if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
			System.err.println("Bu id 'li kişi bulunamadı");
		} else if (response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
			System.err.println("Sunucu hata yaptı -> " + response.getBody());
		} else {
			System.err.println(response != null ? response.getBody() : "");
		}
	}

//	private static void deleteExample()
//	{
//		String url = "http://localhost:8080/ogretmen/deletebyid/{id}";
//		HashMap<String, Object> uriVariables = new HashMap<String, Object>();
//		uriVariables.put("id", 33);
//		ResponseEntity<String> response = null;
//		response = template.exchange(url, HttpMethod.DELETE, null, String.class, uriVariables);
//		if (response.getStatusCode() == HttpStatus.NOT_FOUND)
//		{
//			System.err.println("Bu id 'li kişi bulunamadı");
//		}
//		else if (response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR)
//		{
//			System.err.println("Sunucu hata yaptı -> " + response.getBody());
//		}
//		else
//		{
//			System.err.println(response != null ? response.getStatusCode() + " - " + response.getBody() : "");
//		}
//	}

	private static void getAll() {
		String url = "http://127.0.0.1:8080/ogretmen/getall";
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		System.out.println(response.getBody());
	}
	
//	private static void getAll()
//	{
//		String url = "http://127.0.0.1:8080/ogretmen/getall";
//		ResponseEntity<Ogretmen[]> response = template.getForEntity(url, Ogretmen[].class);
//		System.err.println(response.getStatusCode());
//		Ogretmen[] return_array = response.getBody();
//		List<Ogretmen> liste = Arrays.asList(return_array);
//		System.err.println(liste.getClass());
//		for (Ogretmen ogretmen : liste)
//		{
//			System.err.println(ogretmen);
//		}
//	}
}
