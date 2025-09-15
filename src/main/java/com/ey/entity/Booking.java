package com.ey.entity;

import com.ey.enums.BookingStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	@Enumerated(EnumType.STRING)
	private BookingStatus status;
	@Column(nullable = false)
	private String phoneNumber;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "table_id", nullable = false)
	private DiningTable table;
	@ManyToOne
	@JoinColumn(name = "slot_id", nullable = false)
	private TimeSlot slot;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long id) {
		this.bookingId = id;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus s) {
		this.status = s;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String p) {
		this.phoneNumber = p;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User u) {
		this.user = u;
	}

	public DiningTable getTable() {
		return table;
	}

	public void setTable(DiningTable t) {
		this.table = t;
	}

	public TimeSlot getSlot() {
		return slot;
	}

	public void setSlot(TimeSlot s) {
		this.slot = s;
	}
}
