package com.ey.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.entity.TimeSlot;
import com.ey.repository.TimeSlotRepository;

@Service
public class TimeSlotService {
	private final TimeSlotRepository slotRepo;

	public TimeSlotService(TimeSlotRepository slotRepo) {
		this.slotRepo = slotRepo;
	}

	public TimeSlot createSlot(TimeSlot slot) {
	    List<TimeSlot> existing = slotRepo.findByTableIdAndDate(slot.getTableId(), slot.getDate());
	    for (TimeSlot t : existing) {
	        // Check for exact overlap or time overlap
	        if (
	            (slot.getStartTime().isBefore(t.getEndTime()) && slot.getEndTime().isAfter(t.getStartTime()))
	        ) {
	            throw new IllegalArgumentException("Slot overlaps with an existing slot for this table!");
	        }
	    }
	    return slotRepo.save(slot);
	}

	public void deleteSlot(Long id) {
		if(!slotRepo.existsById(id)) {
			throw new IllegalArgumentException("Slot not found");
		}
		slotRepo.deleteById(id);
	}

	public List<TimeSlot> getAllSlots(Long tableId) {
		return slotRepo.findByTableId(tableId);
	}

	public List<TimeSlot> getAvailableSlots() {
		return slotRepo.findByAvailableTrue();
	}
	
	 
	}
