package com.inventoryproductorder.controller;

import com.inventoryproductorder.dto.ProductOrderRequest;
import com.inventoryproductorder.dto.ProductOrderResponse;
import com.inventoryproductorder.dto.UpdateStatusDto;
import com.inventoryproductorder.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productOrder")
@CrossOrigin(origins = "*")
public class ProductOrderController {

    @Autowired
    ProductOrderService productOrderService;

    @PostMapping
    public ResponseEntity<Map<String, String>> createProductOrderRequest(
            @Valid @RequestBody ProductOrderRequest productOrderRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.productOrderService.createProductOrder(productOrderRequest));
    }

    @GetMapping
    public ResponseEntity<List<ProductOrderResponse>> fetchAllProductOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productOrderService.fetchAllProductOrders());
    }

    @PutMapping
    public ResponseEntity<ProductOrderResponse> UpdateDeliveryStatus(
            @Valid @RequestBody UpdateStatusDto updateStatusDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.productOrderService.updateProductOrderDeliveryStatus(updateStatusDto));
    }

    @GetMapping("/{productOrderId}")
    public ResponseEntity<ProductOrderResponse> getProductOrderById(@PathVariable long productOrderId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.productOrderService.fetchProductOrderById(productOrderId));
    }
}
