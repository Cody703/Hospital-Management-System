package com.qsp.hospitalmanagementsystem.exception;

public class EncounterIdNotFound extends RuntimeException{
//	String message = "Encounter with given Id not found";
//	
//	public String getMassage() {
//		return message;
//	}  
	
	String message ="";
	
	@Override
	public String getMessage() {
		return getMessage();
	}

	public EncounterIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	

}
