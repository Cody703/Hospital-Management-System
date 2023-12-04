package com.qsp.hospitalmanagementsystem.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.hospitalmanagementsystem.util.ResponseStructure;
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(HospitalIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> hospitalIdNotFoundExceptionHandler(HospitalIdNotFound hospitalIdNotFound) {
		
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Id Not Found Exception");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(hospitalIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> BranchIdNotFoundExceptionHandler(BranchIdNotFound branchIdNotFound) {
		
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Id Not Found Exception");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(branchIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> addressIdNotFoundExceptionHandler(AddressIdNotFound addressIdNotFound) {
		
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Id Not Found Exception");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(addressIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PersonIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> personIdNotFoundExceptionHandler(PersonIdNotFound personIdNotFound) {
		
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Id Not Found Exception");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(personIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EncounterIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> EncounterIdNotFoundExceptionHandler(EncounterIdNotFound encounterIdNotFound) {
		
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Id Not Found Exception");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(encounterIdNotFound.getMessage()); 
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	//handlemethodargument
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		List<ObjectError> list = ex.getAllErrors();
		Map<String, String> map = new HashMap<String, String>();
		for (ObjectError objectError : list) {
			FieldError fe = (FieldError) objectError;
			String name = fe.getField();
			String message = fe.getDefaultMessage();
			map.put(name, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
}
