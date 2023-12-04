package com.qsp.hospitalmanagementsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagementsystem.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

	List<Hospital> findHospitallById(int id);

	Hospital findHospitallByName(String name);

}
