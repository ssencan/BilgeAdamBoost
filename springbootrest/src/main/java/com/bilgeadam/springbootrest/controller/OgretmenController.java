package com.bilgeadam.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bilgeadam.springbootrest.model.Ogretmen;
import com.bilgeadam.springbootrest.service.OgretmenService;

@RequestMapping(path = "ogretmen")
@RestController
public class OgretmenController {

	@Autowired
	private OgretmenService ogretmenService;

	@GetMapping("/print")
	public String print() {
		return ogretmenService.print();
	}

	// Bunlar 2. yöntem SeConfigte request matcher kullanmak yerine
//	@Secured(value = "ROLE_USER")
//	@PreAuthorize(value = "isAuthenticated()")
//	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@GetMapping(path = "getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ogretmen>> getall() {
		// localhost:8080/ogretmen/getall
		try {
			return ResponseEntity.ok(ogretmenService.getAllOgretmen());
		} catch (Exception e) {
			// daha sonra değişecek exception handling olacak
			System.err.println(e.getMessage());
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Ogretmen ogr) {
		// localhost:8080/ogretmen/save
		try {
			boolean result = ogretmenService.saveOgretmen(ogr);
			if (result) {
				return ResponseEntity.ok("Kayıt başarı ile kaydedildi");
			} else {
				return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
		}
	}

	@GetMapping(path = "getbyidheader", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogretmen> getbyidheader(@RequestHeader(name = "id") long id) {
		// localhost:8080/ogretmen/getbyidheader
		try {
			return ResponseEntity.ok(ogretmenService.getByIDOgretmen(id));
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping(path = "getbyidqueryparam", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogretmen> getbyidqueryparam(@RequestParam(name = "id") long id) {
		// localhost:8080/ogretmen/getbyidqueryparam?id=1
//		try {
			return ResponseEntity.ok(ogretmenService.getByIDOgretmen(id));
//		} catch (EmptyResultDataAccessException e) {
//			return ResponseEntity.notFound().build();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().build();
//		}
	}

	@GetMapping(path = "getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ogretmen> getbyid(@PathVariable(name = "id") long id) {
		// localhost:8080/ogretmen/getbyid/1
//		try {
			return ResponseEntity.ok(ogretmenService.getByIDOgretmen(id));
//		} catch (EmptyResultDataAccessException e) {
//			return ResponseEntity.notFound().build();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().build();
//		}
	}

	@DeleteMapping(path = "deletebyid/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deletebyid(@PathVariable(name = "id") long id) {
		// localhost:8080/ogretmen/deletebyid/1
		try {
			boolean result = ogretmenService.deleteByIDOgretmen(id);
			if (result) {
				return ResponseEntity.ok(id + "id 'li kayıt başarı ile silindi");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "id 'li kayıt bulunamadı");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(id + "id 'li kayıt silinemedi");
		}
	}

}
