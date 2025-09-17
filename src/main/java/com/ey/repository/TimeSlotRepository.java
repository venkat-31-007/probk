package com.ey.repository;

import com.ey.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
	List <TimeSlot> findByTableId(Long tableId);
	List<TimeSlot> findByTableIdAndDate(Long tableId,LocalDate date);
	List <TimeSlot> findByAvailableTrue();
}
