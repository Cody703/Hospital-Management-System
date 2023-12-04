package com.qsp.hospitalmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagementsystem.dao.MedOrderDao;
import com.qsp.hospitalmanagementsystem.dto.MedOrder;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;
@Service
public class MedOrderService {
	
	@Autowired
	private MedOrderDao medOrderDao;
	ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder, int eid) {
		responseStructure.setMessage("MedOrder Saved SuccessFully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medOrderDao.saveMedOrder(medOrder));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int id) {
			MedOrder medOrder = medOrderDao.deleteMedOrder(id);
			if (medOrder != null) {
				responseStructure.setMessage("MedOrder Deleted SuccessFully");
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(medOrder);
				return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
			}else {
				responseStructure.setMessage("MedOrder Not Found");
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(medOrder);
				return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
			}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id) {
		MedOrder medOrder = medOrderDao.updateMedOrder(id);
		if (medOrder != null) {
			responseStructure.setMessage("MedOrder Updated SuccessFully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(medOrder);
			return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
		}else {
			responseStructure.setMessage("MedOrder Not Found");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(medOrder);
			return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
		}
	}
	
	

}
