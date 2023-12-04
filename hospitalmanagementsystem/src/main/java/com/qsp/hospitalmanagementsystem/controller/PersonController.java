package com.qsp.hospitalmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospitalmanagementsystem.dto.Person;
import com.qsp.hospitalmanagementsystem.service.PersonService;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid @RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Person>> findPersonById(@RequestParam int id) {
		return personService.findPersonById(id);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ResponseStructure<Person>> deletePersonById(@PathVariable int id) {
		return personService.deletePersonById(id);
	}
	
	@GetMapping("/{phone}")
	public ResponseEntity<ResponseStructure<Person>> findPersonByPhone(@PathVariable long phone) {
		return personService.findPersonByPhone(phone);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<ResponseStructure<Person>> findPersonByEmail(@PathVariable String email) {
		return personService.findPersonByEmail(email);
	}
}
