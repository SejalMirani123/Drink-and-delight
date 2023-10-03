package com.inventorystockmanagement.controller;

import com.inventorystockmanagement.entity.RawMaterial;
import com.inventorystockmanagement.entity.RawMaterialStockRequest;
import com.inventorystockmanagement.service.StockManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rawMaterialStock")
@CrossOrigin(origins = "*")
public class RawMaterialController {

    @Autowired
    private StockManagementService stockManagementService;

    @GetMapping
    public ResponseEntity<List<RawMaterial>> findAllRawMaterials() {
        return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.getAllRawMaterials());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RawMaterial> findRawMaterialById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.getRawMaterialById(id));
    }

    @PostMapping
    public ResponseEntity<RawMaterial> addRawMaterial(@RequestBody RawMaterial rawMaterial) {
        return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.saveRawMaterial(rawMaterial));
    }

    @PutMapping
    public ResponseEntity<RawMaterial> updateRawMaterialStock(@RequestBody RawMaterialStockRequest stockRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.updateRawMaterialStock(stockRequest));
    }

}
