package com.rawmaterial.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateStockRequest {
  private Long rawMaterialId;
  private Double quantity;
}
