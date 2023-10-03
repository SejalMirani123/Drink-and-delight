package com.rawmaterial.order.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class RawMaterialOrderRequest {

    @NotNull
    private Long rawMaterialId;
    @NotNull
    private Double quantity;
    @NotNull
    private Double pricePerUnit;
    @Pattern(regexp = "^(Passed|Failed)$", message = "Must be either passed or failed")
    private String qualityCheck;
    @Future
    private LocalDate deliveryDate;
    @Future
    private LocalDate expiryDate;
    private Long supplierId;

}
