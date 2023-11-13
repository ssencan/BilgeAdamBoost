package com.bilgeadam.springbootrest.controller;

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

import com.bilgeadam.springbootrest.model.Ders;
import com.bilgeadam.springbootrest.model.DersDTO;
import com.bilgeadam.springbootrest.model.Konu;
import com.bilgeadam.springbootrest.model.Ogretmen;
import com.bilgeadam.springbootrest.repository.DersRepository;

@RequestMapping(path = "ders")
@RestController
public class DersController {

	private DersRepository ders_repo;

	public DersController(DersRepository ders_repo) {
		this.ders_repo = ders_repo;
	}

	@GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ders>> getall() {

		// localhost:8080/ders/getall
		try {
			return ResponseEntity.ok(ders_repo.getAll());

		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();

		}
	}
	
	@GetMapping(path = "/getalldto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DersDTO>> getalldto() {

		// localhost:8080/ders/getalldto
		try {
			return ResponseEntity.ok(ders_repo.getAllDTO());

		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();

		}
	}

	@GetMapping(path = "/getbyid/{id}")
	public ResponseEntity<Ders> getbyid(@PathVariable(value = "id") long id) {

		// localhost:8080/ders/getbyid/1
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
	
	@GetMapping(path = "/getbyiddto/{id}")
	public ResponseEntity<DersDTO> getbyidDto(@PathVariable(value = "id") long id) {

		// localhost:8080/ders/getbyiddto/1
		try {
			return ResponseEntity.ok(ders_repo.getByIDDTO(id));
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
		// localhost:8080/ders/deletebyid/1
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

//	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> save(@RequestBody Ders ders) {
//		// localhost:8080/ders/save
//		try {
//			boolean result = ders_repo.save(ders);
//			if (result) {
//				return ResponseEntity.ok("Kayıt başarılı");
//			} else {
//				return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
//		}
//	}
	
	//TransactionalSave
	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Ders ders)
	{
		// localhost:8080/ders/save
		try
		{
			Ogretmen ogr = new Ogretmen("yeni öğretmen",false);
			Konu konu = new Konu("yeni konu");
			boolean result = ders_repo.save(ogr,konu);
			if (result)
			{
				return ResponseEntity.ok("Kayıt başarı ile kaydedildi");
			}
			else
			{
				return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
		}
	}
}
