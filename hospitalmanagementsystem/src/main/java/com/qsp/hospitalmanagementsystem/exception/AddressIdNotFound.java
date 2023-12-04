package com.qsp.hospitalmanagementsystem.exception;

public class AddressIdNotFound extends RuntimeException{
//	String message = "Address with given Id not found";
	String message ="";
	
//	public String getMassage() {
//		return message;
//	} 
	
	@Override
	public String getMessage() {
			return getMessage();
		}

	public AddressIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
