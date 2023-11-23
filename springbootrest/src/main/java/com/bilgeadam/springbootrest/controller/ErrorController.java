//package com.bilgeadam.springbootrest.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.BadSqlGrammarException;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestController
//@RestControllerAdvice
//public class ErrorController {
//	
//	@ExceptionHandler
//	public ResponseEntity<String> errorhandler(Exception e){
//		if(e.getClass() == BadSqlGrammarException.class) {
//			return ResponseEntity.status(500).body("Arka planda hata");
//		}
//		else {
//			return ResponseEntity.status(500).body("Sistemde geçiçi hata");
//		}
//	}
//
////	@GetMapping(path= "error")
////	public String errorhandler(){
////		System.out.println("error endpoint olayı");
////		return "error endpointi";
////	}
//}
