package com.qsp.hospitalmanagementsystem.exception;

public class BranchIdNotFound extends RuntimeException{
//	String message = "Branch with given Id not found";
	String message ="";
	
//	public String getMassage() {
//		return message;
//	}
	
	@Override
	public String getMessage() {
		return getMessage();
	}

	public BranchIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
