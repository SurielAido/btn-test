package org.example.price.domain.model.vo;

import org.example.price.domain.exceptions.InvalidPriceBrandIdException;
import org.example.shared.domain.vo.ZonedDateTimeValueObject;

import java.time.ZonedDateTime;
import java.util.Objects;

public class PriceStartDate extends ZonedDateTimeValueObject {

    public PriceStartDate(ZonedDateTime value) throws InvalidPriceBrandIdException {
        super(value);
        check(value);
    }

    public PriceStartDate() {
        super(ZonedDateTime.now());
    }

    private void check(ZonedDateTime value) throws InvalidPriceBrandIdException {
        if (Objects.isNull(value)) {
            throw new InvalidPriceBrandIdException();
        }
    }
}
