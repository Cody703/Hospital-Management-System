package com.qsp.hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagementsystem.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

	Address findByPincode(int pincode);

}
