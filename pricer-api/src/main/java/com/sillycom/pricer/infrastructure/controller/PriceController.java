package com.sillycom.pricer.infrastructure.controller;

import com.sillycom.pricer.application.service.PriceService;
import com.sillycom.pricer.domain.entity.PriceEntity;
import com.sillycom.pricer.infrastructure.dto.response.PriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.Instant;
import java.util.Objects;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class PriceController {
  @Autowired
  private Clock clock;

  @Autowired
  private PriceService priceService;

  @GetMapping(path = "/price/{brand}/{productId}")
  // @Cacheable("product-price-by-brand")
  public ResponseEntity<PriceDto> getProductPriceByBrand(@PathVariable Integer brand,
                                                         @PathVariable Integer productId) {

    Instant instant = clock.instant();
    log.debug("Current date for petition: {}", instant);

    PriceEntity price = priceService.getProductPriceByBrandAndDate(brand, productId, instant);

    if (Objects.isNull(price)){
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(new PriceDto(price.getPrice(), price.getCurr()));
  }
}
