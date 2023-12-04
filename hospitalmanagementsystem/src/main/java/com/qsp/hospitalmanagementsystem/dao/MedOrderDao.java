package com.qsp.hospitalmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagementsystem.dto.MedOrder;
import com.qsp.hospitalmanagementsystem.repo.MedOrderRepo;
@Repository
public class MedOrderDao {
	@Autowired
	private MedOrderRepo medOrderRepo;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return medOrderRepo.save(medOrder);
	}

	public MedOrder deleteMedOrder(int id) {
		Optional<MedOrder> optional = medOrderRepo.findById(id);
		if (optional.isPresent()) {
			MedOrder medOrder = optional.get();
			medOrderRepo.existsById(id);
			return medOrder;
		}
		return null;
	}

	public MedOrder updateMedOrder(int id) {
		Optional<MedOrder> optional = medOrderRepo.findById(id);
		if (optional.isPresent()) {
			MedOrder medOrder = optional.get();
			medOrderRepo.save(medOrder);
			return medOrder;
		}else {
			return null;
		}
		
	}
	
	
	
}
