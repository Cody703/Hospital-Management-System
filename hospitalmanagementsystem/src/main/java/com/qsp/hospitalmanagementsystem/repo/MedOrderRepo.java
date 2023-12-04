package com.qsp.hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagementsystem.dto.MedOrder;

public interface MedOrderRepo extends JpaRepository<MedOrder, Integer>{

}
