package org.example.price.infrastructure.repositories.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.price.domain.exceptions.PriceException;
import org.example.price.domain.model.Price;
import org.example.price.domain.model.vo.*;
import org.example.shared.domain.vo.ZonedDateTimeValueObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "price")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {

    @Id
    private String id;
    @Column(name = "brand_id", nullable = false)
    private Integer brandId;
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;
    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;
    @Column(name = "price_list", nullable = false)
    private Integer priceList;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "priority", nullable = false)
    private Integer priority;
    @Column(name = "price", nullable = false)
    private Double finalPrice;
    @Column(name = "curr", nullable = false)
    private String currency;

    public static Price toDomain(PriceEntity priceEntity) throws PriceException {
        return new Price(new PriceId(priceEntity.getId()),
                new PriceBrandId(priceEntity.getBrandId()),
                new PriceStartDate(ZonedDateTimeValueObject.castTimestampToZonedDateTime(priceEntity.getStartDate())),
                new PriceEndDate(ZonedDateTimeValueObject.castTimestampToZonedDateTime(priceEntity.getEndDate())),
                new PricePriceList(priceEntity.getPriceList()),
                new PriceProductId(priceEntity.getProductId()),
                new PricePriority(priceEntity.getPriority()),
                new PriceFinalPrice(priceEntity.getFinalPrice()),
                new PriceCurrency(priceEntity.getCurrency()));
    }

    public static List<Price> toDomainList(List<PriceEntity> entities) throws PriceException {
        List<Price> prices = new ArrayList<>();
        for (PriceEntity entity : entities) {
            prices.add(toDomain(entity));
        }
        return prices;
    }

    public static PriceEntity fromDomain(Price price) {
        return new PriceEntity(price.getId().value(),
                price.getBrandId().value(),
                ZonedDateTimeValueObject.castZoneDateTimeToTimestap(price.getStartDate().value()),
                ZonedDateTimeValueObject.castZoneDateTimeToTimestap(price.getEndDate().value()),
                price.getPriceList().value(),
                price.getProductId().value(),
                price.getPriority().value(),
                price.getFinalPrice().value(),
                price.getCurrency().value());
    }

    public static List<PriceEntity> fromDomainList(List<Price> prices) {
        return prices.stream().map(PriceEntity::fromDomain).collect(Collectors.toList());
    }
}
