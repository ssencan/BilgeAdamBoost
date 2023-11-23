package com.bilgeadam.springbootrest.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	// @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handleException(Exception e) {
		System.err.println("Genel Exception caught: " + e.getMessage());
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bir hata oluştu");
	}

	@ExceptionHandler(value = ArithmeticException.class)
	// @ResponseStatus(code = HttpStatus.IM_USED, reason = "invalid jdbc usage")

	// bodye string yazbiliyoz artık bir konu falan döndürmicez
	public ResponseEntity<String> aritmetichandler(ArithmeticException e) {
		// server.error.include-message = always
		System.err.println(e.getMessage());
		// isterseniz responseentity döndürebilirsiniz
		return ResponseEntity.status(HttpStatus.IM_USED).body("yanlış kod yazılmış usta123");
		// veya aşağıdaki gibi döndürülebilir
		// return "yazılımcı kodu yanlış yazmış";
	}

	@ExceptionHandler(value = BadSqlGrammarException.class)
	public String badSqlGrammerExceptionHandler(BadSqlGrammarException e) {
		// server.error.include-message = always
		System.err.println("Bad sql yakalandı -> " + e.getMessage());
		return "bad sql hatası";
	}

	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	// @ResponseStatus(code = HttpStatus.IM_USED, reason = "invalid jdbc usage")

	// bodye string yazbiliyoz artık bir konu falan döndürmicez
	public ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
		// server.error.include-message = always
		System.err.println(e.getMessage());
		// isterseniz responseentity döndürebilirsiniz
		//!!!!! Restclientta 404 çıkması için error handling yapmıştık ona göre burada eception string olursa onun yarını extra yapmak lazım o yüzden
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kayıt bulunamadı");
		// veya aşağıdaki gibi döndürülebilir
		// return "yazılımcı kodu yanlış yazmış";
	}
	
	@ExceptionHandler(value = AccessDeniedException.class)
	public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException e) {
	    System.err.println("Access Denied Exception caught: " + e.getMessage());
	    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Bu işlemi gerçekleştirmek için yetkiniz yok.");
	}

//	@ExceptionHandler(value = NullPointerException.class)
//	public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
//	    System.err.println("NullPointerException caught: " + e.getMessage());
//	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kayıt yok kanka.");
//	}
	
}
