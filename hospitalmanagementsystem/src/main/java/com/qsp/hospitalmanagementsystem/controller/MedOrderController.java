package com.qsp.hospitalmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospitalmanagementsystem.dto.MedOrder;
import com.qsp.hospitalmanagementsystem.service.MedOrderService;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("medorder")
public class MedOrderController {
	@Autowired
	private MedOrderService medOrderService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@RequestBody MedOrder medOrder , @RequestParam int eid) {
		return medOrderService.saveMedOrder(medOrder, eid);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@PathVariable int id) {
		return medOrderService.deleteMedOrder(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@RequestParam int id) {
		return medOrderService.updateMedOrder(id);
	}
}
