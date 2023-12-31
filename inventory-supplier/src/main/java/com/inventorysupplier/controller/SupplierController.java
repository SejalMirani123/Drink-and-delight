package com.inventorysupplier.controller;

import com.inventorysupplier.dto.SupplierDto;
import com.inventorysupplier.entity.Supplier;
import com.inventorysupplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@Valid @RequestBody SupplierDto supplier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addSupplier(supplier));
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> fetchAllSupplier() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> fetchSupplierById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getSupplierById(id));
    }

    @PutMapping
    public ResponseEntity<Supplier> updateSupplier(@Valid @RequestBody SupplierDto supplier) {
        return ResponseEntity.status(HttpStatus.OK).body(service.addSupplier(supplier));
    }

}
