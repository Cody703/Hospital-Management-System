package com.qsp.hospitalmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagementsystem.dao.AddressDao;
import com.qsp.hospitalmanagementsystem.dao.BranchDao;
import com.qsp.hospitalmanagementsystem.dao.HospitalDao;
import com.qsp.hospitalmanagementsystem.dto.Address;
import com.qsp.hospitalmanagementsystem.dto.Branch;
import com.qsp.hospitalmanagementsystem.dto.Hospital;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;
@Service
public class BranchService {
	@Autowired
	private BranchDao branchDao;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;
	
	ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();

	public Branch saveBranch(int hid, int aid, Branch branch) {
		Hospital hospital = hospitalDao.findHospitallById(hid);
		Address address = addressDao.getById(aid);
		if (hospital!=null && address != null) {
			branch.setH(hospital);
			branch.setA(address);
			return branchDao.saveBranch(branch);
		}
		return null;
	}


	public ResponseStructure<Branch> findBranchById(int id) {
		Branch branch = branchDao.findBranchById(id);
		if (branch != null) {
			responseStructure.setMessage("Branch Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return responseStructure;
		}else {
			responseStructure.setMessage("Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(branch);
			return responseStructure;
		}
//		return branchDao.findBranchById(id);
	}


	public ResponseStructure<Branch> updateBranch(int id, Branch branch) {
		Branch branch1 = branchDao.updateBranch(id, branch);
		if (branch1 != null) {
			responseStructure.setMessage("Branch Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch1);
			return responseStructure;
		}else {
			responseStructure.setMessage("Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(branch1);
			return responseStructure;
		}
//		return branchDao.updateBranch(id,branch);
	}


	public ResponseStructure<Branch> deleteBranchById(int id) {
		Branch branch = branchDao.deleteBranchById(id);
		if (branch != null) {
			responseStructure.setMessage("Branch Found SuccessFully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return responseStructure;
		}else {
			responseStructure.setMessage("Not Found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(branch);
			return responseStructure;
		}
//		return branchDao.deleteBranchById(id);
	}


	public List<Branch> findBranchByHospital(int hid) {
		Hospital hospital = hospitalDao.findHospitallById(hid);
		
//		Branch branch = branchDao.findBranchByH(hospital);
//		if (branch != null) {
//			responseStructure.setMessage("Branch Found SuccessFully");
//			responseStructure.setStatus(HttpStatus.FOUND.value());
//			responseStructure.setData(branch);
//			return responseStructure;
//		}else {
//			responseStructure.setMessage("Not Found");
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setData(branch);
//			return responseStructure;
//		}
		return branchDao.findBranchByH(hospital);
	}


}
