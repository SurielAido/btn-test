package org.example.price.application;

import lombok.AllArgsConstructor;
import org.example.price.domain.exceptions.PriceException;
import org.example.price.domain.model.Price;
import org.example.price.domain.repositories.PriceRepository;
import org.example.price.infrastructure.responses.PriceResponse;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FindPriceFromStartDateProductIdAndBrandIdService {

    private PriceRepository priceRepository;

    public List<PriceResponse> findPriceFromStartDateProductIdAndBrandId(ZonedDateTime startDate, Long productId, Integer brandId) throws PriceException {
        List<Price> result = priceRepository.findPricesByStartDateProductIdAndBrandId(startDate, productId, brandId);
        return PriceResponse.toResponseList(result);
    }
}
