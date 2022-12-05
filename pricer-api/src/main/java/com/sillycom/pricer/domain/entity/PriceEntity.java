package com.sillycom.pricer.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

import java.time.ZonedDateTime;

@Entity
@Table(name = "PRICES")
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Integer priceList;

  @ManyToOne
  @JoinColumn(name = "BRAND_ID")
  @Getter
  private BrandEntity brand;

  @Getter
  private Integer productId;

  @Getter
  @TimeZoneStorage(TimeZoneStorageType.NATIVE)
  private ZonedDateTime startDate;

  @Getter
  @TimeZoneStorage(TimeZoneStorageType.NATIVE)
  private ZonedDateTime endDate;

  @Getter
  private Integer priority;

  @Getter
  private String curr;

  @Getter
  @Column(nullable = false)
  private Double price;

}
