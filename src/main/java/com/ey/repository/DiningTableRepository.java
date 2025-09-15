package com.ey.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ey.entity.DiningTable;
import com.ey.enums.TableStatus;

public interface DiningTableRepository extends JpaRepository<DiningTable, Long> {
	List<DiningTable> findByStatus(TableStatus status);

	boolean existsByTableNumber(Integer tableNumber);
}

