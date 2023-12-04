package com.qsp.hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagementsystem.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

	Person findPersonByPhone(long phone);

	Person findPersonByEmail(String email);

}
