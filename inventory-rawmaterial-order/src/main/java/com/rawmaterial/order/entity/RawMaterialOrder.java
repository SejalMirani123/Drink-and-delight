package com.rawmaterial.order.entity;

import com.rawmaterial.order.enums.MeasurementUnit;
import com.rawmaterial.order.enums.OrderStatus;
import com.rawmaterial.order.enums.QualityCheck;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RawMaterialOrder {
    @Id
    @SequenceGenerator(name = "raw_material_order_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "raw_material_order_id_sequence", strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long rawMaterialOrderId;

    private Double quantity;
    private Double pricePerUnit;
    @Enumerated(EnumType.STRING)
    private MeasurementUnit measurementUnit;
    @Enumerated(EnumType.STRING)
    private QualityCheck qualityCheck;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDate deliveryDate;
    private LocalDate expiryDate;
    private LocalDate orderedOn;

    @ManyToOne
    @JoinColumn(name = "supplierId", referencedColumnName = "supplierId", foreignKey = @ForeignKey(name = "FK_raw_matr_supplier_ID"))
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "rawMaterialId", referencedColumnName = "rawMaterialId", foreignKey = @ForeignKey(name = "FK_raw_matr_order_ID"))
    private RawMaterial rawMaterial;
}
