package com.sillycom.pricer.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BRANDS")
public class BrandEntity {

  @Id
  @Getter
  private Integer id;

  @Getter
  @Setter
  private String name;

}
