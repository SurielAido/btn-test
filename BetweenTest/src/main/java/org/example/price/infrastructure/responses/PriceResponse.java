package org.example.price.infrastructure.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.price.domain.model.Price;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceResponse {

    private Integer brandId;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private Integer priceList;
    private Long productId;
    private Integer priority;
    private Double finalPrice;
    private String currency;

    public PriceResponse(Price price) {
        this.brandId = price.getBrandId().value();
        this.startDate = price.getStartDate().value();
        this.endDate = price.getEndDate().value();
        this.priceList = price.getPriceList().value();
        this.productId = price.getProductId().value();
        this.priority = price.getPriority().value();
        this.finalPrice = price.getFinalPrice().value();
        this.currency = price.getCurrency().value();
    }

    public static List<PriceResponse> toResponseList(List<Price> prices) {
        return prices.stream().map(PriceResponse::new).collect(Collectors.toList());
    }
}
