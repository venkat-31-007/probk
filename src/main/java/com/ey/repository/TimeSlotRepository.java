package com.ey.repository;

import com.ey.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
	List<TimeSlot> findByDateAndAvailableTrue(LocalDate date);
}
