package com.qsp.hospitalmanagementsystem.controller;

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

import com.qsp.hospitalmanagementsystem.dto.Encounter;
import com.qsp.hospitalmanagementsystem.service.EncounterService;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("encounter")
public class EncounterController {
	@Autowired
	private EncounterService encounterService ;
	
	@PostMapping
	public Encounter saveEncounter(@RequestBody Encounter encounter, @RequestParam int pid, @RequestParam int bid) {
		return encounterService.saveEncounter(encounter, pid, bid);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Encounter>> findEncounterById(@RequestParam int id) {
		return encounterService.findEncounterById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestParam int id) {
		return encounterService.updateEncounter(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@PathVariable int id) {
		return encounterService.deleteEncounter(id);
	}
}
