package com.inventorystockmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RawMaterialStockRequest {

  @NotNull
  private Long rawMaterialId;
  @NotNull
  @DecimalMax(value = "999.99")
  private Double quantity;

}
