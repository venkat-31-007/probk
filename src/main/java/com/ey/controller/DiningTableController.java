package com.ey.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
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

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/admin/tables")
public class DiningTableController {
	private final DiningTableService tableService;

	public DiningTableController(DiningTableService tableService) {
		this.tableService = tableService;
	}

	@PostMapping("")
	public ResponseEntity<DiningTable> addTable(@RequestBody DiningTable table) {
		return ResponseEntity.ok(tableService.addTable(table));
	}

	@GetMapping("")
	public ResponseEntity<List<DiningTable>> getAllTables() {
		return ResponseEntity.ok(tableService.getAllTables());
	}

	@PutMapping("")
	public ResponseEntity<DiningTable> updateTable(@PathVariable Long id, @RequestBody DiningTable table) {
		return ResponseEntity.ok(tableService.updateTable(id, table));
	}

	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteTable(@PathVariable Long id) {
	        try {
	            tableService.deleteTable(id);
	            return ResponseEntity.ok("Table deleted");
	        } catch (EntityNotFoundException ex) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Table not found");
	        } catch (IllegalStateException ex) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot delete a BOOKED table");
	        } catch (IllegalArgumentException ex) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	        } catch (Exception ex) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting table: " + ex.getMessage());
	        }
	    }

	@GetMapping("/available")
	public ResponseEntity<List<DiningTable>> getAvailableTables() {
		return ResponseEntity.ok(tableService.getAvailableTables());
	}
}