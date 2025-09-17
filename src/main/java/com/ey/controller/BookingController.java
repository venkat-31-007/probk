package com.ey.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.DTO.BookingRequest;
import com.ey.entity.Booking;
import com.ey.service.BookingService;

import jakarta.validation.Valid;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	private final BookingService bookingService;

	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@PostMapping
	public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest dto) {
		Booking saved = bookingService.createBooking(dto.getUserId(), dto.getTableId(), dto.getSlotId(),
				dto.getPhoneNumber());
		return ResponseEntity.status(201).body(saved);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Booking>> getByUser(@PathVariable Long userId) {
		return ResponseEntity.ok(bookingService.getBookingsByUser(userId));
	}

	@DeleteMapping("/{bookingId}")
	public ResponseEntity<String> cancel(@PathVariable Long bookingId) {
		bookingService.cancelBooking(bookingId);
		return ResponseEntity.ok("Cancelled");
	}
}