package com.smith.main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = BillNotFoundException.class)
	public ResponseEntity<ErrorResponse> handler1(BillNotFoundException billNotFoundException){
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = billNotFoundException.getMessage();
		ErrorResponse errorMessage = new ErrorResponse(status, message);
		return new ResponseEntity<ErrorResponse>(errorMessage, status);
		
	}
	
	@ExceptionHandler(value = BillSaveErrorException.class)
	public ResponseEntity<ErrorResponse> handler1(BillSaveErrorException billSaveErrorException){
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = billSaveErrorException.getMessage();
		ErrorResponse errorMessage = new ErrorResponse(status, message);
		return new ResponseEntity<ErrorResponse>(errorMessage, status);
		
	}
}
