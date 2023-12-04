package com.qsp.hospitalmanagementsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagementsystem.dto.Branch;
import com.qsp.hospitalmanagementsystem.dto.Hospital;

public interface BranchRepo extends JpaRepository<Branch, Integer> {

	List<Branch> findBranchByH(Hospital hospital);


}
