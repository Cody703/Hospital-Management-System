package com.qsp.hospitalmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagementsystem.dto.Address;
import com.qsp.hospitalmanagementsystem.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return addressRepo.save(address);
	}
	
	public Address getById(int id) {
		// TODO Auto-generated method stub
	    Optional<Address> optional = addressRepo.findById(id);
	    if (optional.isPresent()) {
			return optional.get();
		}
	    return null;
	}

	public Address deleteAddress(int id) {
		// TODO Auto-generated method stub
		Optional<Address> optional = addressRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Address address = optional.get();
		addressRepo.deleteById(id);
		return address;
	}

	public Address updateAddress(int id, Address address) {
		// TODO Auto-generated method stub
	    Optional<Address> optional = addressRepo.findById(id);
	    if (optional.isEmpty()) {
			return null;
		}
	    address.setId(id);
	    return addressRepo.save(address);
	    
	}

	public Address getByPincode(int pincode) {
		// TODO Auto-generated method stub
		return addressRepo.findByPincode(pincode);
	}
}
