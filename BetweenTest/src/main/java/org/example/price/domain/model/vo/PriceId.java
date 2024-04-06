package org.example.price.domain.model.vo;

import org.apache.commons.lang3.StringUtils;
import org.example.price.domain.exceptions.InvalidPriceIdException;
import org.example.shared.domain.vo.StringValueObject;

import java.util.UUID;

public class PriceId extends StringValueObject {

    public PriceId(String value) throws InvalidPriceIdException {
        super(value);
        check(value);
    }

    public PriceId() {
        super(UUID.randomUUID().toString());
    }

    private void check(String value) throws InvalidPriceIdException {
        if (StringUtils.isEmpty(value)) {
            throw new InvalidPriceIdException();
        }
    }
}
