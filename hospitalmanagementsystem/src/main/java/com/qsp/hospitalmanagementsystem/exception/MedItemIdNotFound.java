package com.qsp.hospitalmanagementsystem.exception;

public class MedItemIdNotFound extends RuntimeException{
//	String message = "MedItem with given Id not found";
//	
//	public String getMassage() {
//		return message;
//	} 
	
	String message ="";
	
	@Override
	public String getMessage() {
		return getMessage();
	}

	public MedItemIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	

}
