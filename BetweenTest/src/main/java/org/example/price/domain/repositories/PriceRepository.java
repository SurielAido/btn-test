package org.example.price.domain.repositories;

import org.example.price.domain.exceptions.PriceException;
import org.example.price.domain.model.Price;
import org.example.price.infrastructure.repositories.jpa.PriceEntity;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findPricesByStartDateProductIdAndBrandId(ZonedDateTime startDate, Long productId, Integer brandId) throws PriceException;
}
