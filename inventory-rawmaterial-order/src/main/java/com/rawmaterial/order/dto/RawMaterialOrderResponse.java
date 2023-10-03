package com.rawmaterial.order.dto;

import com.rawmaterial.order.entity.Warehouse;
import com.rawmaterial.order.enums.MeasurementUnit;
import com.rawmaterial.order.enums.OrderStatus;
import com.rawmaterial.order.enums.QualityCheck;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterialOrderResponse {

  private Long rawMaterialOrderId;
  private Double pricePerUnit;
  private Double quantity;
  private QualityCheck qualityCheck;
  private OrderStatus orderStatus;
  private LocalDate deliveryDate;
  private LocalDate expiryDate;
  private LocalDate orderedOn;
  private String supplierName;
  private Long supplierId;
  private String materialName;
  private String description;
  private MeasurementUnit measurementUnit;
  private Warehouse warehouse;

}
