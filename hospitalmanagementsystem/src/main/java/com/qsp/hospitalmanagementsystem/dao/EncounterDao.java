package com.qsp.hospitalmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagementsystem.dto.Encounter;
import com.qsp.hospitalmanagementsystem.repo.EncounterRepo;
@Repository
public class EncounterDao {
	@Autowired
	private EncounterRepo encounterRepo;

	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepo.save(encounter);
	}
	
	public Encounter findEncounterById(int id) {
		Optional<Encounter> optional = encounterRepo.findById(id);
		if (optional != null) {
			return optional.get();
		}
		return null;
	}

	public Encounter updateEncounter(int id) {
		Optional<Encounter> optional = encounterRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}else {
			Encounter encounter = optional.get();
			encounterRepo.save(encounter);
			return encounter;
		}
	}
	
	public Encounter deleteEncounter(int id) {
		Optional<Encounter> optional = encounterRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}else {
			Encounter encounter = optional.get();
			encounterRepo.deleteById(id);
			return encounter;
		}
		
	}
}
