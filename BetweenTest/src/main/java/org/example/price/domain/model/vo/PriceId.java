package org.example.price.domain.model.vo;

import org.apache.commons.lang3.StringUtils;
import org.example.price.domain.exceptions.invalidPriceIdException;
import org.example.shared.domain.vo.StringValueObject;

import java.util.UUID;

public class PriceId extends StringValueObject {

    public PriceId(String value) throws invalidPriceIdException {
        super(value);
        check(value);
    }

    public PriceId() {
        super(UUID.randomUUID().toString());
    }

    private void check(String value) throws invalidPriceIdException {
        if (StringUtils.isEmpty(value)) {
            throw new invalidPriceIdException();
        }
    }
}
