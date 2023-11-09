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

import com.bilgeadam.springrest.model.Ders;
import com.bilgeadam.springrest.model.DersDTO;
import com.bilgeadam.springrest.repository.DersRepository;

@RequestMapping(path = "ders")
@RestController
public class DersController {

	private DersRepository ders_repo;

	public DersController(DersRepository ders_repo) {
		this.ders_repo = ders_repo;
	}

	@GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ders>> getall() {

		// localhost:8080/springrest/ders/getall
		try {
			return ResponseEntity.ok(ders_repo.getAll());

		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();

		}
	}
	
	@GetMapping(path = "/getalldto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DersDTO>> getalldto() {

		// localhost:8080/springrest/ders/getalldto
		try {
			return ResponseEntity.ok(ders_repo.getAllDTO());

		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();

		}
	}

	@GetMapping(path = "/getbyid/{id}")
	public ResponseEntity<Ders> getbyid(@PathVariable(value = "id") long id) {

		// localhost:8080/springrest/ders/getbyid/1
		try {
			return ResponseEntity.ok(ders_repo.getByID(id));
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Kayıt bulunamadı");
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable(value = "id") long id) {
		// localhost:8080/springrest/ders/deletebyid/1
		try {
			boolean result = ders_repo.deleteByID(id);
			if (result) {
				return ResponseEntity.ok(id + "id 'li kayıt başarı ile silindi");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "id 'li kayıt bulunamadı");
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(id + "id 'li kayıt silinemedi");
		}
	}

	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Ders ders) {
		// localhost:8080/springrest/ders/save
		try {
			boolean result = ders_repo.save(ders);
			if (result) {
				return ResponseEntity.ok("Kayıt başarılı");
			} else {
				return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
		}
	}
}
