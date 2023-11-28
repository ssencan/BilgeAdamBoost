package com.bilgeadam.springbootrest.restclient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.bilgeadam.springbootrest.model.Ogretmen;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MyRestClientExample {

	private final WebClient webClient;

	public MyRestClientExample() {
		this.webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
	}

	public void getByIdEntity() {
		String url = "/ogretmen/getbyid/{id}";

		// WebClient kullanarak GET isteği gönder
		Mono<ResponseEntity<Ogretmen>> responseEntityMono = webClient.get().uri(url, 2).retrieve()
				.toEntity(Ogretmen.class)// Yanıtı Ogretmen sınıfına dönüştür
				.onErrorResume(WebClientResponseException.class, ex -> {
					if (ex.getRawStatusCode() == 404) {
						System.out.println(ex.getStatusCode());
						System.out.println("Ogretmen bulunamadı.");
						return Mono.empty(); // Hata durumunda boş bir Mono döndür
					} else {
						// Diğer hataları tekrar fırlat
						System.out.println("HTTP Hata Kodu: " + ex.getRawStatusCode());
						System.out.println("Hata Mesajı: " + ex.getResponseBodyAsString());
						return Mono.error(ex);
					}
				});
		// Yanıtı bloklamak ve işlemek için bekleyen bir Response Entity al
		ResponseEntity<Ogretmen> responseEntity = responseEntityMono.block();

		Ogretmen ogretmen = responseEntity.getBody();
		System.out.println(responseEntity.getStatusCode());
		System.out.println("Ogretmen ID: " + ogretmen.getID());
		System.out.println("Ogretmen NAME: " + ogretmen.getNAME());
		// Diğer özellikler de aynı şekilde yazdırılabilir

	}

	public void getAllEntity() {
		String url = "/ogretmen/getall";

		// WebClient kullanarak GET isteği gönder
		Flux<Ogretmen> ogretmenList = webClient.get().uri(url).retrieve()
				.onStatus(status -> status.is4xxClientError() || status.is5xxServerError(), response -> {
					HttpStatus statusCode = (HttpStatus) response.statusCode();
					System.out.println(statusCode.value() + " " + statusCode.getReasonPhrase());

					// Hata detaylarını logla
					response.bodyToMono(String.class).doOnNext(errorBody -> {
						System.out.println("Hata Detayı: " + errorBody);
					}).subscribe();

					return response.createException().flatMap(Mono::error);
				}).onStatus(status -> status.is2xxSuccessful(), response -> {
					HttpStatus statusCode = (HttpStatus) response.statusCode();
					System.out.println(statusCode.value() + " " + statusCode.getReasonPhrase());
					return Mono.empty(); // 200 OK durumunda boş bir Mono döndür
				}).bodyToFlux(Ogretmen.class);

		// Diğer işlemler...
		ogretmenList.collectList().block().forEach(ogretmen -> {
			System.out.println("Ogretmen ID: " + ogretmen.getID());
			System.out.println("Ogretmen NAME: " + ogretmen.getNAME());
			System.out.println("GICIK: " + ogretmen.isIS_GICIK());
		});
	}

}
