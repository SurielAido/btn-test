package price.domain;

import lombok.Builder;
import net.datafaker.Faker;
import org.example.price.domain.exceptions.*;
import org.example.price.domain.model.Price;
import org.example.price.domain.model.vo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
public class PriceMother {

    @Builder.Default
    private PriceId id = defaultPriceId();
    @Builder.Default
    private PriceBrandId brandId = defaultPriceBrandId();
    @Builder.Default
    private PriceStartDate startDate = defaultPriceStartDate();
    @Builder.Default
    private PriceEndDate endDate = defaultPriceEndDate();
    @Builder.Default
    private PricePriceList priceList = defaultPricePriceList();
    @Builder.Default
    private PriceProductId productId = defaultPriceProductId();
    @Builder.Default
    private PricePriority priority = defaultPricePriority();
    @Builder.Default
    private PriceFinalPrice finalPrice = defaultPriceFinalPrice();
    @Builder.Default
    private PriceCurrency currency = defaultPriceCurrency();

    public static Price random() {
        PriceMother mother = PriceMother.builder().build();
        return mother.get();
    }

    public static List<Price> getRandomList(int size) {
        List<Price> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(random());
        }
        return result;
    }

    public Price get() {
        return new Price(
                id, brandId, startDate, endDate, priceList, productId, priority, finalPrice, currency
        );
    }

    private static PriceId defaultPriceId() {
        try {
            return new PriceId(UUID.randomUUID().toString());
        } catch (InvalidPriceIdException ex) {
            return null;
        }
    }

    private static PriceBrandId defaultPriceBrandId() {
        try {
            return new PriceBrandId(new Faker().number().numberBetween(1, 10));
        } catch (InvalidPriceBrandIdException ex) {
            return null;
        }
    }

    private static PriceStartDate defaultPriceStartDate() {
        return new PriceStartDate();
    }

    private static PriceEndDate defaultPriceEndDate() {
        return new PriceEndDate();
    }

    private static PricePriceList defaultPricePriceList() {
        try {
            return new PricePriceList(new Faker().number().numberBetween(1, 4));
        } catch (InvalidPricePriceListException ex) {
            return null;
        }
    }

    private static PriceProductId defaultPriceProductId() {
        try {
            return new PriceProductId(new Faker().number().randomNumber());
        } catch (InvalidPriceProductIdException ex) {
            return null;
        }
    }

    private static PricePriority defaultPricePriority() {
        try {
            return new PricePriority(new Faker().number().numberBetween(0, 1));
        } catch (InvalidPricePriorityException ex) {
            return null;
        }
    }

    private static PriceFinalPrice defaultPriceFinalPrice() {
        try {
            return new PriceFinalPrice(new Faker().number().randomDouble(2, 10, 100));
        } catch (InvalidPriceFinalPriceException ex) {
            return null;
        }
    }

    private static PriceCurrency defaultPriceCurrency() {
        try {
            return new PriceCurrency(new Faker().currency().code());
        } catch (InvalidPriceCurrencyException ex) {
            return null;
        }
    }
}
