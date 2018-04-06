package com.creditcard.bureo.exception;

public class InvalidCreditCardException extends RuntimeException {
	
	private String errorMsg;
	
	public InvalidCreditCardException(){
		
		super();
	}
	
	public InvalidCreditCardException(String errorMessage){
		super(errorMessage);
		this.errorMsg=errorMessage;
	}

}
