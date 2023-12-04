package com.qsp.hospitalmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospitalmanagementsystem.dto.MedItem;
import com.qsp.hospitalmanagementsystem.service.MedItemService;
import com.qsp.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("medItem")
public class MedItemController {

	@Autowired
	private MedItemService medItemService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MedItem>> saveMedItem(@RequestBody MedItem medItem,@RequestParam int mid) {
		return medItemService.saveMedItem(medItem, mid);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<MedItem>> findMedItemById(@RequestParam int id) {
		return medItemService.findMedItemById(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<MedItem>> updateMedItem(@RequestParam int id) {
		return medItemService.updateMedItem(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MedItem>> deleteMedItem(@RequestParam int id) {
		return medItemService.deleteMedItem(id);
	}
}
