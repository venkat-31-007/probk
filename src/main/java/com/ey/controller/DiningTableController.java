package com.ey.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.entity.DiningTable;
import com.ey.service.DiningTableService;

@RestController
@RequestMapping("/api/auth")
public class DiningTableController {
	private final DiningTableService tableService;

	public DiningTableController(DiningTableService tableService) {
		this.tableService = tableService;
	}

	@PostMapping("/admin/tables")
	public ResponseEntity<DiningTable> addTable(@RequestBody DiningTable table) {
		return ResponseEntity.ok(tableService.addTable(table));
	}

	@GetMapping("/admin/tables")
	public ResponseEntity<List<DiningTable>> getAllTables() {
		return ResponseEntity.ok(tableService.getAllTables());
	}

	@PutMapping("/admin/tables/{id}")
	public ResponseEntity<DiningTable> updateTable(@PathVariable Long id, @RequestBody DiningTable table) {
		return ResponseEntity.ok(tableService.updateTable(id, table));
	}

	@DeleteMapping("/admin/tables/{id}")
	public ResponseEntity<String> deleteTable(@PathVariable Long id) {
		tableService.deleteTable(id);
		return ResponseEntity.ok("Table deleted");
	}

	@GetMapping("/tables/available")
	public ResponseEntity<List<DiningTable>> getAvailableTables() {
		return ResponseEntity.ok(tableService.getAvailableTables());
	}
}