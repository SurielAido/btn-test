package org.example.price.infrastructure.repositories.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;
import java.util.List;

public interface PriceJpaRepository extends PagingAndSortingRepository<PriceEntity, String> {

    @Query(value = "select * from public.price where start_date < :startDate and product_id = :productId and brand_id = :brandId",
            nativeQuery = true)
    List<PriceEntity> findPricesByStartDateProductIdAndBrandId(Timestamp startDate, Long productId, Integer brandId);
}
