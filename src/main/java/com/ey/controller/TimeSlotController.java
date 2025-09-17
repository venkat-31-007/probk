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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ey.entity.TimeSlot;
import com.ey.service.TimeSlotService;

@RestController
@RequestMapping("/api/admin/timeslots")
public class TimeSlotController {
	private final TimeSlotService slotService;

	public TimeSlotController(TimeSlotService slotService) {
		this.slotService = slotService;
	}

	@PostMapping("")
	public ResponseEntity<TimeSlot> createSlot(@RequestBody TimeSlot slot) {
		return ResponseEntity.ok(slotService.createSlot(slot));
	}

	@GetMapping("/{tableId}")
	public ResponseEntity<List<TimeSlot>> getSlotsForTable(@PathVariable Long tableId) {
		return ResponseEntity.ok(slotService.getAllSlots(tableId));
	}
	@DeleteMapping("/{slotId}")
	public ResponseEntity<String> deleteSlot(@PathVariable Long slotId) {
	    try {
	        slotService.deleteSlot(slotId);
	        return ResponseEntity.ok("Deleted");
	    } catch (IllegalArgumentException ex) {
	        return ResponseEntity.status(404).body(ex.getMessage());
	    } catch (Exception ex) {
	        return ResponseEntity.status(500).body("Error deleting slot: " + ex.getMessage());
	    }
	}
	
	

	@GetMapping("/available")
	public ResponseEntity<List<TimeSlot>> getAvailableSlots() {
	    List<TimeSlot> slots = slotService.getAvailableSlots();
	    return ResponseEntity.ok(slots);
	}
	 
}
