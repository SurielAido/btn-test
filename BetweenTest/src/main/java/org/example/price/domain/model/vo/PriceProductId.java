package org.example.price.domain.model.vo;

import org.example.price.domain.exceptions.InvalidPriceProductIdException;
import org.example.shared.domain.vo.LongValueObject;

import java.util.Objects;

public class PriceProductId extends LongValueObject {

    public PriceProductId(Long value) throws InvalidPriceProductIdException {
        super(value);
        check(value);
    }

    public PriceProductId() {
        super(0L);
    }

    private void check(Long value) throws InvalidPriceProductIdException {
        if (Objects.isNull(value)) {
            throw new InvalidPriceProductIdException();
        }
    }
}
