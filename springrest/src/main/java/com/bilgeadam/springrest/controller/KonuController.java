package com.bilgeadam.springrest.controller;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bilgeadam.springrest.model.Konu;
import com.bilgeadam.springrest.repository.KonuRepository;

@RestController
@RequestMapping(path = "/konu")
public class KonuController {

	private KonuRepository konurepo;

	public KonuController(KonuRepository konurepo) {
		this.konurepo = konurepo;
	}

	@GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Konu>> getall() {
		// localhost:8080/springrest/konu/getall
		try {
			return ResponseEntity.ok(konurepo.getAll());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping(path = "/getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Konu> getbyid(@PathVariable(name = "id") long id) {
		// localhost:8080/springrest/konu/getbyid/1
		try {
			return ResponseEntity.ok(konurepo.getByID(id));
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Kayıt bulunamadı");
			e.getMessage();
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping(path = "/deletebyid/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deletebyid(@PathVariable(name = "id") long id) {
		// localhost:8080/springrest/konu/deletebyid/1
		try {
			boolean result = konurepo.deleteByID(id);
			if (result) {
				return ResponseEntity.ok(id + "id 'li kayıt başarı ile silindi");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "id 'li kayıt bulunamadı");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(id + "id 'li kayıt başarı ile silindi");
		}
	}

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Konu konu) {
		// localhost:8080/jakartarest/konu/save
		try {
			boolean result = konurepo.save(konu);
			if (result) {
				return ResponseEntity.ok("Kayıt başarılı");
			} else {
				return ResponseEntity.internalServerError().body("Kayıt başarısız");
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
		}
	}

}
