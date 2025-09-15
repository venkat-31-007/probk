package com.ey.DTO;

import jakarta.validation.constraints.*;

public class BookingRequest {
	@NotNull
	private Long userId;
	@NotNull
	private Long tableId;
	@NotNull
	private Long slotId;
	@Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid phone number")
	private String phoneNumber;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long u) {
		this.userId = u;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long t) {
		this.tableId = t;
	}

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long s) {
		this.slotId = s;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String p) {
		this.phoneNumber = p;
	}
}