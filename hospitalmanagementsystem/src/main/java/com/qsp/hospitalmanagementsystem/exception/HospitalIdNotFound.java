package com.qsp.hospitalmanagementsystem.exception;

public class HospitalIdNotFound extends RuntimeException {
	
//	String message = "Hospital with given Id not found";
	private String message;
	
//	public String getMassage() {
//		return message;
//	}
	
	@Override
		public String getMessage() {
			// TODO Auto-generated method stub
			return message;
		}

	public HospitalIdNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}
