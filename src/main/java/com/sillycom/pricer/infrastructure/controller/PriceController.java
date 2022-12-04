package com.sillycom.pricer.infrastructure.controller;

import com.sillycom.pricer.infrastructure.dto.response.PriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.util.Date;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class PriceController {
  @Autowired
  private Clock clock;

  @GetMapping(path = "/price/{brand}/{productId}")
  @Cacheable("product-price-by-brand")
  public ResponseEntity<PriceDto> getProductPriceByDateAndBrand(@PathVariable Integer productId,
                                                                @PathVariable String brand) {

    Date date = Date.from(clock.instant());
    log.debug("Current date for petition: {}", date);

    return ResponseEntity.ok().body(new PriceDto());
  }
}
