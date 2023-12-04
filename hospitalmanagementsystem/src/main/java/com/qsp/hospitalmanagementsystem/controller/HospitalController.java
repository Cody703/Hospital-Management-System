package com.qsp.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospitalmanagementsystem.dto.Hospital;
import com.qsp.hospitalmanagementsystem.service.HospitalService;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
	@Autowired
	private HospitalService service;

	@ApiOperation(notes = "This api is use to save the hospital details into the db", value = "Hospital Save API")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Data saved Successfully") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return service.saveHospital(hospital);
	}

	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Hospital>>> findAllHospitall() {
		return service.findAllHospitall();
	}

	@GetMapping // ("/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> findHospitallById(@RequestParam int id) {
		return service.findHospitallById(id);
	}

	@GetMapping("/{name}")
	public ResponseEntity<ResponseStructure<Hospital>> findHospitallByName(@PathVariable String name) {
		return service.findHospitallByName(name);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,
			@RequestBody Hospital hospital) {
		return service.updateHospital(id, hospital);
	}

	@DeleteMapping
	private ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@RequestParam int id) {
		// TODO Auto-generated method stub
		return service.deleteHospital(id);

	}
}
