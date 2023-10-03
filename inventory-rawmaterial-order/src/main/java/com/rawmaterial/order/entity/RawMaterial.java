package com.rawmaterial.order.entity;

import com.rawmaterial.order.enums.MeasurementUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RawMaterial {
    @Id
    @SequenceGenerator(name = "rawmaterial_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "rawmaterial_id_sequence", strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long rawMaterialId;
    @Column(length = 20)
    private String materialName;
    @Column(length = 100)
    private String description;
    private Double quantityAvailable;
    @Enumerated(EnumType.STRING)
    private MeasurementUnit quantityUnit;
    @ManyToOne
    @JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId", foreignKey = @ForeignKey(name = "FK_raw_matr_warehouse_ID"))
    private Warehouse warehouse;
}
