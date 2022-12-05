package com.sillycom.pricer.domain.repository;

import com.sillycom.pricer.domain.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

  List<PriceEntity> getByBrandIdAndProductId(Integer brandId, Integer productId);
}
