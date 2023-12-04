package com.qsp.hospitalmanagementsystem.exception;

public class MedOrderIdNotFound extends RuntimeException{
//	String message = "MedOrder with given Id not found";
//	
//	public String getMassage() {
//		return message;
//	} 
	
	String message ="";
	
	@Override
	public String getMessage() {
		return getMessage();
	}

	public MedOrderIdNotFound(String message) {
		super();
		this.message = message;
	}
	

}
