package com.ey.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ey.entity.Booking;
import com.ey.entity.User;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	List<Booking> findByUser(User user);

	List<Booking> findBySlot_SlotId(Long slotId);
}
