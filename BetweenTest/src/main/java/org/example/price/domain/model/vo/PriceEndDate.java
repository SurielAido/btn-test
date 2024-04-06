package org.example.price.domain.model.vo;

import org.example.price.domain.exceptions.InvalidPriceEndDateException;
import org.example.shared.domain.vo.ZonedDateTimeValueObject;

import java.time.ZonedDateTime;
import java.util.Objects;

public class PriceEndDate extends ZonedDateTimeValueObject {

    public PriceEndDate(ZonedDateTime value) throws InvalidPriceEndDateException {
        super(value);
        check(value);
    }

    public PriceEndDate() {
        super(ZonedDateTime.now());
    }

    private void check(ZonedDateTime value) throws InvalidPriceEndDateException {
        if (Objects.isNull(value)) {
            throw new InvalidPriceEndDateException();
        }
    }
}
