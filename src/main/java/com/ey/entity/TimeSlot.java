package com.ey.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.*;

@Entity
@Table(name = "time_slots")
public class TimeSlot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slotId;
	@NotNull
	private Long tableId;
	@NotNull
	private LocalDate date;
	@NotNull
	private LocalTime startTime;
	@NotNull
	private LocalTime endTime;
	private boolean available = true;

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long id) {
		this.slotId = id;
	}

	
	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate d) {
		this.date = d;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime t) {
		this.startTime = t;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime t) {
		this.endTime = t;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean a) {
		this.available = a;
	}
}
