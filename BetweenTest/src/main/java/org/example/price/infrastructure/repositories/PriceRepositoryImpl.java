package org.example.price.infrastructure.repositories;

import lombok.AllArgsConstructor;
import org.example.price.domain.exceptions.PriceException;
import org.example.price.domain.model.Price;
import org.example.price.domain.repositories.PriceRepository;
import org.example.price.infrastructure.repositories.jpa.PriceEntity;
import org.example.price.infrastructure.repositories.jpa.PriceJpaRepository;
import org.example.shared.domain.vo.ZonedDateTimeValueObject;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {

    private PriceJpaRepository jpaRepository;


    @Override
    public List<Price> findPricesByStartDateProductIdAndBrandId(ZonedDateTime startDate, Long productId, Integer brandId) throws PriceException {
        List<PriceEntity> entities = jpaRepository.findPricesByStartDateProductIdAndBrandId(ZonedDateTimeValueObject.castZoneDateTimeToTimestap(startDate), productId, brandId);
        return PriceEntity.toDomainList(entities);
    }
}
