package com.qsp.hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagementsystem.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter,Integer>{

}
