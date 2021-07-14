package com.hdi.insurance.api.exceptionhandler;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hdi.insurance.api.exception.BusinessException;


@ControllerAdvice
public class HDIExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {BusinessException.class})
	public ResponseEntity<Object> handleBusinessException(Exception ex, WebRequest request){
		
		String description = ex.getLocalizedMessage();
		description = description == null ? ex.toString() : description;
		Error error = new Error(description);
		
		return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	public static class Error {
		
		private String message;
		
		public Error(String message) {			
			this.message = message;			
		}
		
		public String getMessage() {
			return message;
		}
	}

}
