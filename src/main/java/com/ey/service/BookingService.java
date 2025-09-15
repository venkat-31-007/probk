package com.ey.service;

import com.ey.entity.*;
import com.ey.enums.*;
import com.ey.exception.*;
import com.ey.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private DiningTableRepository tableRepo;
	@Autowired
	private TimeSlotRepository slotRepo;

	public Booking createBooking(Long userId, Long tableId, Long slotId, String phone) {
		User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
		DiningTable table = tableRepo.findById(tableId).orElseThrow(() -> new RuntimeException("Table not found"));
		TimeSlot slot = slotRepo.findById(slotId).orElseThrow(() -> new RuntimeException("Slot not found"));
		if (!slot.isAvailable())
			throw new SlotAlreadyBookedException("Slot already booked");
		Booking b = new Booking();
		b.setUser(user);
		b.setTable(table);
		b.setSlot(slot);
		b.setPhoneNumber(phone);
		b.setStatus(BookingStatus.BOOKED);
		Booking saved = bookingRepo.save(b);
		slot.setAvailable(false);
		slotRepo.save(slot);
		table.setStatus(TableStatus.BOOKED);
		tableRepo.save(table);
		return saved;
	}

	public void cancelBooking(Long bookingId) {
		Booking b = bookingRepo.findById(bookingId)
				.orElseThrow(() -> new BookingNotFoundException("Booking not found"));
		b.setStatus(BookingStatus.CANCELLED);
		bookingRepo.save(b);
		TimeSlot slot = b.getSlot();
		slot.setAvailable(true);
		slotRepo.save(slot);
		DiningTable table = b.getTable();
		table.setStatus(TableStatus.AVAILABLE);
		tableRepo.save(table);
	}

	public List<Booking> getBookingsByUser(Long userId) {
		User u = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
		return bookingRepo.findByUser(u);
	}
}
