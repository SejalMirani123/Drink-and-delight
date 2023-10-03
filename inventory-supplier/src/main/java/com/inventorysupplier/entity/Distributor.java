package com.inventorysupplier.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Distributor {

  @Id
  @SequenceGenerator(name = "distributor_id_sequence", initialValue = 100000, allocationSize = 1)
  @GeneratedValue(generator = "distributor_id_sequence", strategy = GenerationType.SEQUENCE)
  private Long distributorId;
  @Column(length = 20)
  private String name;
  @Column(length = 30)
  private String location;
  @Column(length = 10)
  private String phoneNo;

}
