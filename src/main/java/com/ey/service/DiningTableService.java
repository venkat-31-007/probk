package com.ey.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.ey.entity.DiningTable;
import com.ey.enums.TableStatus;
import com.ey.repository.DiningTableRepository;

@Service
public class DiningTableService {
	private final DiningTableRepository tableRepo;

	public DiningTableService(DiningTableRepository tableRepo) {
		this.tableRepo = tableRepo;
	}

	public DiningTable addTable(DiningTable table) {
		table.setStatus(TableStatus.AVAILABLE);
		return tableRepo.save(table);
	}

	public List<DiningTable> getAllTables() {
		return tableRepo.findAll();
	}

	public List<DiningTable> getAvailableTables() {
		return tableRepo.findByStatus(TableStatus.AVAILABLE);
	}

	public DiningTable updateTable(Long id, DiningTable updated) {
		DiningTable t = tableRepo.findById(id).orElseThrow(() -> new RuntimeException("Table not found"));
		t.setTableNumber(updated.getTableNumber());
		t.setSeats(updated.getSeats());
		t.setStatus(updated.getStatus());
		return tableRepo.save(t);
	}

	public void deleteTable(Long id) {
		tableRepo.deleteById(id);
	}
}