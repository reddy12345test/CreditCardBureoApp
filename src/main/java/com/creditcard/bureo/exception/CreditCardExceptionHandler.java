package com.creditcard.bureo.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.creditcard.bureo.model.CreditCardResponse;
import com.creditcard.bureo.rest.CreditCardBureoController;

@ControllerAdvice
public class CreditCardExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Log logger = LogFactory.getLog(CreditCardBureoController.class);
	
	@ExceptionHandler(value = { InvalidCreditCardException.class })
    protected ResponseEntity<Object> handleCardError(RuntimeException ex, WebRequest request) {
        CreditCardResponse error= new CreditCardResponse("FAILURE","","Invalid SSN provided");
        return handleExceptionInternal(ex, error, 
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
	
	@ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request) {
        CreditCardResponse error= new CreditCardResponse("FAILURE","",ex.getMessage());
        return handleExceptionInternal(ex, error, 
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
