package com.sillycom.pricer.application.service;

import com.sillycom.pricer.domain.entity.PriceEntity;

import java.time.Instant;

public interface PriceService {
  PriceEntity getProductPriceByBrandAndDate(Integer brand, Integer productId, Instant instant);
}
