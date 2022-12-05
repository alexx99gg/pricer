package com.sillycom.pricer.application.service;

import com.sillycom.pricer.application.comparator.PriceComparator;
import com.sillycom.pricer.domain.entity.PriceEntity;
import com.sillycom.pricer.domain.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PriceServiceImpl implements PriceService {

  @Autowired
  private PriceRepository priceRepository;

  @Autowired
  private PriceComparator priceComparator;

  public PriceEntity getProductPriceByBrandAndDate(Integer brand, Integer productId, Instant instant){

    var prices = priceRepository.getByBrandIdAndProductId(brand, productId);

    var applyingPrices = prices.parallelStream()
        .filter(v -> doesPriceApply(v, instant))
        .sorted(priceComparator)
        .toList();

    if (applyingPrices.isEmpty()){
      return null;
    }

    return applyingPrices.get(0);
  }

  private boolean doesPriceApply(PriceEntity price, Instant instant) {

    return (price.getStartDate().toInstant().isBefore(instant) && price.getEndDate().toInstant().isAfter(instant));
  }
}
