package com.inventoryproductorder.dto;

import com.inventoryproductorder.entity.Warehouse;
import com.inventoryproductorder.enums.MeasurementUnit;
import com.inventoryproductorder.enums.OrderStatus;
import com.inventoryproductorder.enums.QualityCheck;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrderResponse {

    private Long productOrderId;
    private Double quantity;
    private Double pricePerUnit;
    private QualityCheck qualityCheck;
    private OrderStatus orderStatus;
    private LocalDate deliveryDate;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private LocalDate orderedOn;
    private String distributorName;
    private Long distributorId;
    private String productName;
    private String description;
    private MeasurementUnit measurementUnit;
    private Warehouse warehouse;
    private Long productId;
}
