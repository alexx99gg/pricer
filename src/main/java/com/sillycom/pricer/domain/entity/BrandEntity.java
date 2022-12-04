package com.sillycom.pricer.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pricer_brands")
public class BrandEntity {

  @Id
  private Integer id;

  @Getter
  @Setter
  private String name;

}
