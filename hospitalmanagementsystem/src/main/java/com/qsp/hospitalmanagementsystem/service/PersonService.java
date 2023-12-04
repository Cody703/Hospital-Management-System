package com.qsp.hospitalmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagementsystem.dao.PersonDao;
import com.qsp.hospitalmanagementsystem.dto.Person;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;
@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;
	ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();

	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		responseStructure.setMessage("Person Saved SuccessFully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(personDao.savePerson(person));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
//		return personDao.savePerson(person);
	}

	public ResponseEntity<ResponseStructure<Person>> findPersonById(int id) {
		Person person = personDao.findPersonById(id);
		if (person != null) {
			responseStructure.setMessage("Person Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(personDao.savePerson(person));
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		}else {
			responseStructure.setMessage("Person Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(personDao.savePerson(person));
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
//		return personDao.findPersonById(id);
	}

	public ResponseEntity<ResponseStructure<Person>> deletePersonById(int id) {
		Person person = personDao.findPersonById(id);
		if(person != null) {
			responseStructure.setMessage("Person Deleted SuccessFully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("Person Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
		}
//		return personDao.deletePersonById(id);
	}

	public ResponseEntity<ResponseStructure<Person>> findPersonByPhone(long phone) {
		Person person = personDao.findPersonByPhone(phone);
		if (person != null) {
			responseStructure.setMessage("Person Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		}else {
			responseStructure.setMessage("Person Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
		
	}

	public ResponseEntity<ResponseStructure<Person>> findPersonByEmail(String email) {
		Person person = personDao.findPersonByEmail(email);
		if (person != null) {
			responseStructure.setMessage("Person Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		}else {
			responseStructure.setMessage("Person Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

}
