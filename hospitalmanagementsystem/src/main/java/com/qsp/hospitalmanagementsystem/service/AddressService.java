package com.qsp.hospitalmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagementsystem.dao.AddressDao;
import com.qsp.hospitalmanagementsystem.dto.Address;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setMessage("Hospital Saved SuccessFully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
//		return addressDao.saveAddress(address);
	}

	public ResponseEntity<ResponseStructure<Address>> getById(int id) {
		Address address = addressDao.getById(id);
		if (address != null) {
			responseStructure.setMessage("Address Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		}else {
			responseStructure.setMessage("Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(address);
			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
//		return addressDao.getById(id);
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		Address address = addressDao.deleteAddress(id);
		if (address != null) {
			responseStructure.setMessage("Address Deleted SuccessFully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new  ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(address);
			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
//		return addressDao.deleteAddress(id);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, Address address) {
		Address address1 = addressDao.updateAddress(id, address);
		if (address != null) {
			responseStructure.setMessage("Address Updated SuccessFully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address1);
			return new  ResponseEntity<>(responseStructure, HttpStatus.OK);
		}else {
			responseStructure.setMessage("Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(address1);
			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
//		return addressDao.updateAddress(id, address);
	}

	public ResponseEntity<ResponseStructure<Address>> getByPincode(int pincode) {
		Address address = addressDao.getByPincode(pincode);
		if (address != null) {
			responseStructure.setMessage("Address Through pincode Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new  ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		}else {
			responseStructure.setMessage("Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(address);
			return new  ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
//		return addressDao.getByPincode(pincode);
	}
	
	
}
