package org.example.price.domain.model.vo;

import org.example.price.domain.exceptions.InvalidPriceFinalPriceException;
import org.example.shared.domain.vo.DoubleValueObject;

import java.util.Objects;

public class PriceFinalPrice extends DoubleValueObject {

    public PriceFinalPrice(Double value) throws InvalidPriceFinalPriceException {
        super(value);
        check(value);
    }

    public PriceFinalPrice() {
        super(0.);
    }

    private void check(Double value) throws InvalidPriceFinalPriceException {
        if (Objects.isNull(value)) {
            throw new InvalidPriceFinalPriceException();
        }
    }
}
