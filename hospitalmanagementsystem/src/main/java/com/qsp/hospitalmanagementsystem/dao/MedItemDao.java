package com.qsp.hospitalmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagementsystem.dto.MedItem;
import com.qsp.hospitalmanagementsystem.repo.MedItemRepo;
@Repository
public class MedItemDao {

	@Autowired
	private MedItemRepo medItemRepo;
	
	public MedItem saveMedItem(MedItem medItem) {
		return medItemRepo.save(medItem);
	}

	public MedItem findMedItemById(int id) {
		Optional<MedItem> optional = medItemRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public MedItem updateMedItem(int id) {
		Optional<MedItem> optional = medItemRepo.findById(id);
		if(optional.isPresent()) {
			MedItem medItem = optional.get();
			medItemRepo.save(medItem);
			return medItem;
		}
		return null;
	}

	public MedItem deleteMedItem(int id) {
		Optional<MedItem> optional = medItemRepo.findById(id);
		if(optional.isPresent()) {
			medItemRepo.deleteById(id);
			return optional.get();
		}
		return null;
	}
	
}
