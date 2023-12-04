package com.qsp.hospitalmanagementsystem.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagementsystem.dao.HospitalDao;
import com.qsp.hospitalmanagementsystem.dto.Hospital;
import com.qsp.hospitalmanagementsystem.exception.HospitalIdNotFound;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;
@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;
	
	ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		responseStructure.setMessage("Hospital Saved SuccessFully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveHospital(hospital));
		return new  ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Hospital>>> findAllHospitall() {
		ResponseStructure<List<Hospital>> lresponseStructure = new ResponseStructure<>();
		List<Hospital> list = dao.findAllHospitall();
		if (list.isEmpty()) {
			lresponseStructure.setMessage("All Hospital List Not Found SuccessFully");
			lresponseStructure.setStatus(HttpStatus.FOUND.value());
			lresponseStructure.setData(list);
			return new  ResponseEntity<>(lresponseStructure, HttpStatus.FOUND);
		}else {
//			lresponseStructure.setMessage("All Hospital Found SuccessFully");
//			lresponseStructure.setStatus(HttpStatus.FOUND.value());
//			lresponseStructure.setData(null);
//			return new  ResponseEntity<>(lresponseStructure, HttpStatus.FOUND);
			throw new HospitalIdNotFound("Hospital with given Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> findHospitallById(int id) {
		Hospital hospital = dao.findHospitallById(id);
		if (hospital!=null) {
			responseStructure.setMessage("Hospital Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new  ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		}else {
//			responseStructure.setMessage("Hospital Not Found");
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setData(null);
//			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
			throw new HospitalIdNotFound("Hospital with given Id not found");
		}
		
	}

	public ResponseEntity<ResponseStructure<Hospital>> findHospitallByName(String name) {
		Hospital hospital = dao.findHospitallByName(name);
		if (hospital!=null) {
			responseStructure.setMessage("Hospital Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new  ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		}else {
//			responseStructure.setMessage("Hospital Not Found");
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setData(null);
//			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
			throw new HospitalIdNotFound("Hospital with given Id not found");
		}
//		return dao.findHospitallByName(name);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
//		return dao.updateHospital(id, hospital)
		Hospital hospital1 = dao.updateHospital(id, hospital);
		if (hospital != null) {
			responseStructure.setMessage("Hospital Deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital1);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else {
//			responseStructure.setMessage("Hospital Not Found");
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setData(null);
//			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
			throw new HospitalIdNotFound("Hospital with given Id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		Hospital hospital = dao.deleteHospital(id);
		if (hospital != null) {
			responseStructure.setMessage("Hospital Deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else {
//			responseStructure.setMessage("Hospital Not Found");
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setData(null);
//			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
			throw new HospitalIdNotFound("Hospital with given Id not found");
		}
		
		
//		return dao.deleteHospital(id);
	}

}
