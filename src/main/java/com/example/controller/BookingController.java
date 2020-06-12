/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BookingOutputModel;
import com.example.service.BookingService;

/**
 * @author apple
 *
 */
@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;

	@PostMapping(path = "/bookCab")
	public ResponseEntity<BookingOutputModel> bookCab(@RequestParam String pinCode) {

		BookingOutputModel bookingOutputModel = bookingService.bookCab(pinCode);

		return ResponseEntity.ok().body(bookingOutputModel);
	}
}
