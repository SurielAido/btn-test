package org.example.price.domain.model;

import lombok.*;
import org.example.price.domain.model.vo.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Price {

    private PriceId id;
    private PriceBrandId brandId;
    private PriceStartDate startDate;
    private PriceEndDate endDate;
    private PricePriceList priceList;
    private PriceProductId productId;
    private PricePriority priority;
    private PriceFinalPrice finalPrice;
    private PriceCurrency currency;
}
