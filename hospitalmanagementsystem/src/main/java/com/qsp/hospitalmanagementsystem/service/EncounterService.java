package com.qsp.hospitalmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagementsystem.dao.BranchDao;
import com.qsp.hospitalmanagementsystem.dao.EncounterDao;
import com.qsp.hospitalmanagementsystem.dao.PersonDao;
import com.qsp.hospitalmanagementsystem.dto.Branch;
import com.qsp.hospitalmanagementsystem.dto.Encounter;
import com.qsp.hospitalmanagementsystem.dto.Person;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;
@Service
public class EncounterService {
	@Autowired
	private EncounterDao encounterDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private BranchDao branchDao;
	
	ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
	
	public Encounter saveEncounter(Encounter encounter, int pid, int bid) {
		
		Branch branch = branchDao.findBranchById(bid);
		Person person = personDao.findPersonById(pid);
		
		if (person != null && branch != null) {
			encounter.setPerson(person);
			List<Branch> list = new ArrayList<Branch>();
			list.add(branch);
			
			encounter.setBranchs(list);
			return encounterDao.saveEncounter(encounter);
		}
		return null;
//		responseStructure.setMessage("Ecounter Saved SuccessFully");
//		responseStructure.setStatus(HttpStatus.CREATED.value());
//		responseStructure.setData(encounterDao.saveEncounter(encounter));
//		return responseStructure;
	}

	public ResponseEntity<ResponseStructure<Encounter>> findEncounterById(int id) {
		Encounter encounter = encounterDao.findEncounterById(id);
		if (encounter != null) {
			responseStructure.setMessage("Ecounter Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			return new  ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		}else {
			responseStructure.setMessage("Ecounter Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(encounter);
			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int id) {
		Encounter encounter = encounterDao.updateEncounter(id);
		if (encounter != null) {
			responseStructure.setMessage("Ecounter Updated SuccessFully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new  ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("Ecounter Counld Be Updated");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(encounter);
			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id) {
		Encounter encounter = encounterDao.updateEncounter(id);
		if (encounter != null) {
			responseStructure.setMessage("Ecounter Updated SuccessFully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new  ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("Ecounter Counld Be Updated");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(encounter);
			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

}
