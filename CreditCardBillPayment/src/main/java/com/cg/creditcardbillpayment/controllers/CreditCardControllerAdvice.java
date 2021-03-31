package com.cg.creditcardbillpayment.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.creditcardbillpayment.exceptions.CreditCardServiceException;

@RestControllerAdvice
public class CreditCardControllerAdvice {
	
	@ExceptionHandler(CreditCardServiceException.class)
	
	public ResponseEntity<String> foundCreditCardException(Exception exception){
		
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		
		
	}
}
