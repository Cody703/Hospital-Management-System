package com.qsp.hospitalmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagementsystem.dto.Branch;
import com.qsp.hospitalmanagementsystem.dto.Hospital;
import com.qsp.hospitalmanagementsystem.repo.BranchRepo;
@Repository
public class BranchDao {
	@Autowired
	private BranchRepo branchRepo;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch findBranchById(int id) {
		Optional<Branch> optional = branchRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Branch updateBranch(int id, Branch branch) {
		Optional<Branch> optional = branchRepo.findById(id);
		if (optional.isPresent()) {
			branch.setId(id);
			return branchRepo.save(branch);
		}
		return null;
	}

	public Branch deleteBranchById(int id) {
		Optional<Branch> optional = branchRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		branchRepo.deleteById(id);
		return optional.get();
//		return "id :" +id+" got deleted"; 
	}

	public List<Branch> findBranchByH(Hospital hospital) {
		return branchRepo.findBranchByH(hospital);
	}
	
	

}
