package com.inventorystockmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductStockRequest {
  
  @NotNull
  private Long productId;

  @NotNull
  @DecimalMax(value = "999.99")
  private Double quantity;

}
