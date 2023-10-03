package com.inventorystockmanagement.repository;

import com.inventorystockmanagement.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long>{
	
}
