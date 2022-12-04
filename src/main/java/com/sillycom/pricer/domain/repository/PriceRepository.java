package com.sillycom.pricer.domain.repository;

import com.sillycom.pricer.domain.entity.PriceEntity;
import com.sillycom.pricer.domain.entity.PriceCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, PriceCompositeKey> {
}
