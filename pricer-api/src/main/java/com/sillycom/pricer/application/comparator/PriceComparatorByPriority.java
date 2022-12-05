package com.sillycom.pricer.application.comparator;

import com.sillycom.pricer.domain.entity.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class PriceComparatorByPriority implements Comparator<PriceEntity> {
  public int compare(PriceEntity price1, PriceEntity price2) {
    return Integer.compare(price2.getPriority(), price1.getPriority());
  }
}
