/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CabRegistrationInputModel;
import com.example.service.CabService;

/**
 * @author apple
 *
 */
@RestController
public class CabController {
	@Autowired
	CabService cabService;

	@PostMapping(path = "/addCab")
	public ResponseEntity<Void> addNewCab(@RequestBody CabRegistrationInputModel cabRegistrationInputModel) {

		cabService.addnewCab(cabRegistrationInputModel);

		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = "/updateCabLocation")
	public ResponseEntity<Void> updateCabLocation(@RequestParam Integer cabId, @RequestParam Integer latitude,
			@RequestParam Integer longitude) {

		cabService.updateCabLocation(cabId, latitude, longitude);

		return ResponseEntity.noContent().build();
	}

	@GetMapping(path = "/updateCabAvailability")
	public ResponseEntity<Void> updateCabAvailability(@RequestParam Integer cabId, @RequestParam boolean busy) {

		cabService.switchAvailability(cabId, busy);

		return ResponseEntity.noContent().build();
	}
}
