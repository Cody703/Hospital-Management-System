package com.qsp.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospitalmanagementsystem.dto.Branch;
import com.qsp.hospitalmanagementsystem.service.BranchService;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("branch")
public class BranchController {
	@Autowired
	private BranchService branchService;
	
	@PostMapping
	public Branch saveBranch(@RequestParam int hid,@RequestParam int aid,@RequestBody Branch branch) {
		return branchService.saveBranch(hid, aid, branch);
	}
	
	@GetMapping
	public ResponseStructure<Branch> findBranchById(@RequestParam int id) {
		return branchService.findBranchById(id);
	}
	
	@PutMapping
	public ResponseStructure<Branch> updateBranch(@RequestParam int id, @RequestBody Branch branch) {
		return branchService.updateBranch(id, branch);
	}
	
	@DeleteMapping
	public ResponseStructure<Branch> deleteBranchById(@RequestParam int id) {
		return branchService.deleteBranchById(id);
	}
	
	@GetMapping("/{hid}")
	public List<Branch> findBranchByHospital(@PathVariable int hid) {
		return branchService.findBranchByHospital(hid);
	}
}
