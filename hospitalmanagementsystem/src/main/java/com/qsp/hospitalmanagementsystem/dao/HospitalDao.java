package com.qsp.hospitalmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagementsystem.dto.Hospital;
import com.qsp.hospitalmanagementsystem.repo.HospitalRepo;
@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepo repo;
	
	public Hospital saveHospital(Hospital hospital) {
		return repo.save(hospital);
	}

	public List<Hospital> findAllHospitall() {
		return repo.findAll();
	}

	public Hospital findHospitallById(int id) {
		Optional<Hospital> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Hospital findHospitallByName(String name) {
		// TODO Auto-generated method stub
		return repo.findHospitallByName(name);
	}

	public Hospital updateHospital(int id, Hospital hospital) {
		Optional<Hospital> optional = repo.findById(id);
		if (optional.isPresent()) {
			hospital.setId(id);
			return repo.save(hospital);
		}
		return null;
	}

	public Hospital deleteHospital(int id) {
		Optional<Hospital> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}
	
	

}
