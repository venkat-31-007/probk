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
		return slotRepo.save(slot);
	}

	public void deleteSlot(Long id) {
		slotRepo.deleteById(id);
	}

	public List<TimeSlot> getAllSlots() {
		return slotRepo.findAll();
	}

	public List<TimeSlot> getAvailableSlots(LocalDate date) {
		return slotRepo.findByDateAndAvailableTrue(date);
	}
}