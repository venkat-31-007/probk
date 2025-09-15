package com.ey.entity;

import com.ey.enums.TableStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "dining_tables", uniqueConstraints = @UniqueConstraint(columnNames = "tableNumber"))
public class DiningTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tableId;
	@NotNull
	private Integer tableNumber;
	@Min(1)
	private int seats;
	@Enumerated(EnumType.STRING)
	private TableStatus status = TableStatus.AVAILABLE;

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long id) {
		this.tableId = id;
	}

	public Integer getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(Integer n) {
		this.tableNumber = n;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int s) {
		this.seats = s;
	}

	public TableStatus getStatus() {
		return status;
	}

	public void setStatus(TableStatus st) {
		this.status = st;
	}
}
