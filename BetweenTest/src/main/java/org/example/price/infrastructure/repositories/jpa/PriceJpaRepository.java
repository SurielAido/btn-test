package org.example.price.infrastructure.repositories.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PriceJpaRepository extends PagingAndSortingRepository<PriceEntity, String> {
}
