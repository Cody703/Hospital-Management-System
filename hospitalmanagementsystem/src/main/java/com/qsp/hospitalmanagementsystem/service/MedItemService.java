package com.qsp.hospitalmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagementsystem.dao.MedItemDao;
import com.qsp.hospitalmanagementsystem.dto.MedItem;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;
@Service
public class MedItemService {

	@Autowired
	private MedItemDao medItemDao;
	ResponseStructure<MedItem> responseStructure = new ResponseStructure<MedItem>();

	public ResponseEntity<ResponseStructure<MedItem>> saveMedItem(MedItem medItem, int mid) {
		responseStructure.setMessage("MedItem Saved SuccessFully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medItemDao.saveMedItem(medItem));
		return new  ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<MedItem>> findMedItemById(int id) {
		MedItem medItem = medItemDao.findMedItemById(id);
		if (medItem != null) {
			responseStructure.setMessage("MedItem Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(medItem);
			return new  ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		}else {
			responseStructure.setMessage("MedItem Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(medItem);
			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<MedItem>> updateMedItem(int id) {
		MedItem medItem = medItemDao.updateMedItem(id);
		if (medItem != null) {
			responseStructure.setMessage("MedItem Updated SuccessFully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(medItem);
			return new  ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("MedItem Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(medItem);
			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<MedItem>> deleteMedItem(int id) {
		MedItem medItem = medItemDao.deleteMedItem(id);
		if (medItem != null) {
			responseStructure.setMessage("MedItem Updated SuccessFully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(medItem);
			return new  ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("MedItem Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(medItem);
			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
