package com.inventoryproductorder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class ProductOrderRequest {

	@NotNull
	@Min(100000)
	@Max(999999)
	private Long productId;
	@NotNull
	@DecimalMax(value = "9999.999")
	private Double quantity;
	@NotNull
	@DecimalMax(value = "9999.999")
	private Double pricePerUnit;
	@Pattern(regexp = "^(Passed|Failed)$", message = "Must be either passed or failed")
	private String qualityCheck;
	@NotNull
	@Future
	private LocalDate deliveryDate;
	@NotNull
	@Future
	private LocalDate expiryDate;
	@NotNull
	@Past
	private LocalDate manufactureDate;
	@NotNull
	@Min(100000)
	@Max(999999)
	private Long distributorId;

}
