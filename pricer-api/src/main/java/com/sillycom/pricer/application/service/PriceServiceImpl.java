package com.sillycom.pricer.application.service;

import com.sillycom.pricer.application.comparator.PriceComparatorByPriority;
import com.sillycom.pricer.domain.entity.PriceEntity;
import com.sillycom.pricer.domain.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

  @Autowired
  private PriceRepository priceRepository;

  @Autowired
  private PriceComparatorByPriority priceComparatorByPriority;

  public PriceEntity getProductPriceByBrandAndDate(Integer brand, Integer productId, Instant instant){

    List<PriceEntity> prices = priceRepository.getByBrandIdAndProductId(brand, productId);

    List<PriceEntity> applyingPricesSortedByPriority = prices.parallelStream()
        .filter(price -> doesPriceApply(price, instant))
        .sorted(priceComparatorByPriority)
        .toList();

    if (applyingPricesSortedByPriority.isEmpty()){
      return null;
    }

    return applyingPricesSortedByPriority.get(0);
  }

  private boolean doesPriceApply(PriceEntity price, Instant instant) {
    return (price.getStartDate().toInstant().isBefore(instant) && price.getEndDate().toInstant().isAfter(instant));
  }
}
