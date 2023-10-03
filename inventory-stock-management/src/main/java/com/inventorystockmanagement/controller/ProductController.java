package com.inventorystockmanagement.controller;

import com.inventorystockmanagement.entity.Product;
import com.inventorystockmanagement.entity.ProductStockRequest;
import com.inventorystockmanagement.service.StockManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productStock")
@CrossOrigin(origins = "*")
public class ProductController {

  @Autowired
	private StockManagementService stockManagementService;

	@GetMapping
	public ResponseEntity<List<Product>> findAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.getAllProducts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.getProductById(id));
	}

  @PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.saveProduct(product));
  }
  
  @PutMapping
	public ResponseEntity<Product> updateProductStock(@RequestBody ProductStockRequest stockRequest) {
    return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.updateProductStock(stockRequest));
  }

}
