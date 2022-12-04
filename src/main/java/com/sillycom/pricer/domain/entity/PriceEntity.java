package com.sillycom.pricer.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Entity
@Table(name = "pricer_prices")
@IdClass(PriceCompositeKey.class)
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {
  @Id
  private Integer brandId;
  @Id
  private Integer productId;
  @Id
  private Date startDate;
  @Id
  private Date endDate;
  @Id
  private Integer priority;
  @Id
  private String curr;

  @NonNull
  private Double price;

}
