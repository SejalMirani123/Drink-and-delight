package com.inventorysupplier.controller;

import com.inventorysupplier.dto.WarehouseDto;
import com.inventorysupplier.entity.Warehouse;
import com.inventorysupplier.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/warehouse")
@CrossOrigin(origins = "*")
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    @PostMapping
    public ResponseEntity<Warehouse> addWarehouse(@Valid @RequestBody WarehouseDto warehouse) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createWarehouse(warehouse));
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> fetchAllWarehouses() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getWarehouses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> fetchWarehouseById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.fetchWarehouseById(id));
    }

    @PutMapping
    public ResponseEntity<Warehouse> updateWarehouse(@Valid @RequestBody WarehouseDto warehouse) {
        return ResponseEntity.status(HttpStatus.OK).body(service.createWarehouse(warehouse));
    }

}
