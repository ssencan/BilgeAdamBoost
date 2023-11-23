package com.bilgeadam.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bilgeadam.springbootrest.model.Konu;
import com.bilgeadam.springbootrest.repository.KonuRepository;
import com.bilgeadam.springbootrest.service.KonuService;

@RestController
@RequestMapping(path = "/konu")
//@RestControllerAdvice( basePackageClasses = KonuService.class)
public class KonuController {

	@Autowired
	private KonuService konuService;
	
//	@ExceptionHandler(value = BadSqlGrammarException.class)
//	public String badSqlGrammerExceptionHandler(BadSqlGrammarException e)
//	{
//		// server.error.include-message = always
//		System.err.println("Bad sql yakalandı -> " + e.getMessage());
//		return "bad sql hatası";
//	}
	
//	@ExceptionHandler(value = ArithmeticException.class)
//	//@ResponseStatus(code = HttpStatus.IM_USED, reason = "invalid jdbc usage")
//	
//	//bodye string yazbiliyoz artık bir konu falan döndürmicez
//		public String aritmetichandler(ArithmeticException e)
//		{
//			// server.error.include-message = always
//			System.err.println(e.getMessage());
//			// isterseniz responseentity döndürebilirsiniz
//			// return ResponseEntity.status(HttpStatus.IM_USED).body("yanlış kod yazılmış usta");
//			// veya aşağıdaki gibi döndürülebilir
//			return "yazılımcı kodu yanlış yazmış";
//		}

	@GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Konu>> getall() {
		// localhost:8080/konu/getall
//		try {
			return ResponseEntity.ok(konuService.getAllKonu());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return ResponseEntity.internalServerError().build();
//		}
	}

	@GetMapping(path = "/getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Konu> getbyid(@PathVariable(name = "id") long id) {
		// localhost:8080/konu/getbyid/1
//		try {
		return ResponseEntity.ok(konuService.getByIDKonu(id));
//		} catch (EmptyResultDataAccessException e) {
//			System.out.println("Kayıt bulunamadı");
//			e.getMessage();
//			return ResponseEntity.notFound().build();
//		} catch (Exception e) {
//			e.getMessage();
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().build();
//		}
	}

	@DeleteMapping(path = "/deletebyid/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deletebyid(@PathVariable(name = "id") long id) {
		// localhost:8080/konu/deletebyid/1
//		try {
			boolean result = konuService.deleteByIDKonu(id);
			if (result) {
				return ResponseEntity.ok(id + "id 'li kayıt başarı ile silindi");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "id 'li kayıt bulunamadı");
			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().body(id + "id 'li kayıt başarı ile silindi");
//		}
	}

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Konu konu) {
		// localhost:8080/jakartarest/konu/save
//		try {
			boolean result = konuService.saveKonu(konu);
			if (result) {
				return ResponseEntity.ok("Kayıt başarılı");
			} else {
				return ResponseEntity.internalServerError().body("Kayıt başarısız");
			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			e.getMessage();
//			return ResponseEntity.internalServerError().body("Kayıt başarı ile kaydedilemedi");
//		}
	}

}
