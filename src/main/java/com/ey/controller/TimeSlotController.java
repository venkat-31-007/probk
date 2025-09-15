package com.ey.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ey.entity.TimeSlot;
import com.ey.service.TimeSlotService;

@RestController
public class TimeSlotController {
	private final TimeSlotService slotService;

	public TimeSlotController(TimeSlotService slotService) {
		this.slotService = slotService;
	}

	@PostMapping("/api/admin/slots")
	public ResponseEntity<TimeSlot> createSlot(@RequestBody TimeSlot slot) {
		return ResponseEntity.ok(slotService.createSlot(slot));
	}

	@GetMapping("/api/admin/slots")
	public ResponseEntity<List<TimeSlot>> getAllSlots() {
		return ResponseEntity.ok(slotService.getAllSlots());
	}

	@DeleteMapping("/api/admin/slots/{id}")
	public ResponseEntity<String> deleteSlot(@PathVariable Long id) {
		slotService.deleteSlot(id);
		return ResponseEntity.ok("Deleted");
	}

	@GetMapping("/api/slots/available")
	public ResponseEntity<List<TimeSlot>> getAvailableSlots(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return ResponseEntity.ok(slotService.getAvailableSlots(date));
	}
}
