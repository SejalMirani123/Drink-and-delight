package com.rawmaterial.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Warehouse {

    @Id
    @SequenceGenerator(name = "warehouse_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "warehouse_id_sequence", strategy = GenerationType.SEQUENCE)
//  @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long warehouseId;
    @Column(length = 20)
    private String name;
    @Column(length = 50)
    private String description;

}
