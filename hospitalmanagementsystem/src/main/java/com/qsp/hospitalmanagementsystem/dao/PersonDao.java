package com.qsp.hospitalmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagementsystem.dto.Person;
import com.qsp.hospitalmanagementsystem.repo.PersonRepo;
@Repository
public class PersonDao {
	@Autowired
	private PersonRepo personRepo;
	
	public Person savePerson(Person person) {
		return personRepo.save(person);
	}

	public Person findPersonById(int id) {
		Optional<Person> optional = personRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public String deletePersonById(int id) {
		Optional<Person> optional = personRepo.findById(id);
		if (optional.isPresent()) {
			Person person = optional.get();
			personRepo.deleteById(id);
//			optional.get();
			return "id : "+id+" got deleted : "+ person;
		}
		return "No Data Found";
	}

	public Person findPersonByPhone(long phone) {
		return personRepo.findPersonByPhone(phone);
	}

	public Person findPersonByEmail(String email) {
		return personRepo.findPersonByEmail(email);
	}

}
