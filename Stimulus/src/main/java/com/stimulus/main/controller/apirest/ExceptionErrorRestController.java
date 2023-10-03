package com.stimulus.main.controller.apirest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stimulus.main.exception.ErrorInfo;

@RestControllerAdvice
public class ExceptionErrorRestController {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> errorException(Exception exception) {
		System.out.println("TAL DO ERROR: " + exception.getMessage());
		ErrorInfo errorHandler = new ErrorInfo("Deu erro ali ó", exception);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorHandler);
	}
}