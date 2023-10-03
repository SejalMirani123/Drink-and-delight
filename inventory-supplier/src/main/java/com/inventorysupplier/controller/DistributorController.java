package com.inventorysupplier.controller;

import com.inventorysupplier.dto.DistributorDto;
import com.inventorysupplier.entity.Distributor;
import com.inventorysupplier.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/distributor")
@CrossOrigin(origins = "*")
public class DistributorController {

    @Autowired
    private DistributorService service;

    @PostMapping
    public ResponseEntity<Distributor> addDistributor(@Valid @RequestBody DistributorDto distributor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addDistributor(distributor));
    }

    @GetMapping
    public ResponseEntity<List<Distributor>> fetchAllDistributors() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getDistributors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Distributor> fetchDistributorById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getDistributorById(id));
    }

    @PutMapping
    public ResponseEntity<Distributor> updateDistributor(@Valid @RequestBody DistributorDto distributor) {
        return ResponseEntity.status(HttpStatus.OK).body(service.addDistributor(distributor));
    }

}
