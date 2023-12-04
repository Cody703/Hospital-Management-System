package com.qsp.hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagementsystem.dto.MedItem;

public interface MedItemRepo extends JpaRepository<MedItem, Integer>{

}
