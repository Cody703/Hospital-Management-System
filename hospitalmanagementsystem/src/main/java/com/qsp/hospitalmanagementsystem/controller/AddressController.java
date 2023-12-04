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

import com.qsp.hospitalmanagementsystem.dto.Address;
import com.qsp.hospitalmanagementsystem.service.AddressService;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;
@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getById(@RequestParam int id) {
		return addressService.getById(id);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int id) {
		return addressService.deleteAddress(id);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int id, @RequestBody Address address) {
		return addressService.updateAddress(id, address);
	}

	@GetMapping("/{pincode}")
	public ResponseEntity<ResponseStructure<Address>> getByPincode(@PathVariable int pincode) {
		return addressService.getByPincode(pincode);
	}
}
