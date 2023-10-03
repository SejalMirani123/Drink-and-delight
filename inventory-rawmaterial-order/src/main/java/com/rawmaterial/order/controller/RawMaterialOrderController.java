package com.rawmaterial.order.controller;

import com.rawmaterial.order.dto.RawMaterialOrderRequest;
import com.rawmaterial.order.dto.RawMaterialOrderResponse;
import com.rawmaterial.order.dto.UpdateStatusDto;
import com.rawmaterial.order.service.RawMaterialOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rawMaterialOrder")
@CrossOrigin(origins = "*")
public class RawMaterialOrderController {

	@Autowired
	private RawMaterialOrderService service;

	// Create Order
	@PostMapping
	public ResponseEntity<Map<String, String>> createOrder(
			@Valid @RequestBody RawMaterialOrderRequest rawMaterialOrderRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.createRawMaterialOrder(rawMaterialOrderRequest));
	}

	// Update Delivery Status
	@PutMapping
	public ResponseEntity<RawMaterialOrderResponse> UpdateDeliveryStatus(@Valid @RequestBody UpdateStatusDto updateStatusDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(this.service.updateRawMaterialOrderDeliveryStatus(updateStatusDto));
	}

	// Find a particular order by its ID
	@GetMapping("/{id}")
	public ResponseEntity<RawMaterialOrderResponse> findRawMaterialOrderById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.fetchRawMaterialOrderById(id));
	}

	// Fetch all the Orders
	@GetMapping
	public ResponseEntity<List<RawMaterialOrderResponse>> FetchAllOrders() {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.fetchAllOrders());
	}

}
