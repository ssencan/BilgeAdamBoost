package com.bilgeadam.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.bilgeadam.springbootrest.model.Ogrenci;
import com.bilgeadam.springbootrest.repository.OgrenciRepository;
import com.bilgeadam.springbootrest.service.OgrenciService;

@RestController
@RequestMapping(path = "/ogrenci")
public class OgrenciController {

	@Autowired
	private OgrenciService ogrenci_service;

	@GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ogrenci>> getall() {
		// localhost:8080/ogrenci/getall
		try {
			return ResponseEntity.ok(ogrenci_service.getAllOgrenci());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping(path = "/getbyid/{id}")
	public ResponseEntity<Ogrenci> getbyid(@PathVariable(value = "id") long id) {
		// localhost:8080/ogrenci/getbyid/1
		try {
			return ResponseEntity.ok(ogrenci_service.getByIDOgrenci(id));
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Kayıt bulunamadı");
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping(path = "/deletebyid/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deletebyid(@PathVariable(value = "id") long id) {
		// localhost:8080/ogrenci/deletebyid/1
		try {
			boolean result = ogrenci_service.deleteByIDOgrenci(id);
			if (result) {
				return ResponseEntity.ok(id + "id 'li kayıt başarı ile silindi");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "id 'li kayıt bulunamadı");
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(id + "id 'li kayıt silinemedi");
		}
	}

	@PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Ogrenci ogr) {
		// localhost:8080/ogrenci/save
		try {
			boolean result = ogrenci_service.saveOgrenci(ogr);
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
	
	 @GetMapping("/print2")
	    public String print() {
	        return ogrenci_service.print2();
	    }

}
