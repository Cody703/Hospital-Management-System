package com.qsp.hospitalmanagementsystem.exception;

public class PersonIdNotFound extends RuntimeException{
//	String message = "Person with given Id not found";
//	
//	public String getMassage() {
//		return message;
//	} 
	
	String message ="";
	
	@Override
	public String getMessage() {
		return getMessage();
	}

	public PersonIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	

}
