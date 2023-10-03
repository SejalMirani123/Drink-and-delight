package com.rawmaterial.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supplier {
  @Id
  @SequenceGenerator(name = "supplier_id_sequence", initialValue = 100000, allocationSize = 1)
  @GeneratedValue(generator = "supplier_id_sequence", strategy = GenerationType.SEQUENCE)
//  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long supplierId;
  @Column(length = 20)
  private String name;
  @Column(length = 30)
  private String location;
  @Column(length = 10)
  private String phoneNo;
}
