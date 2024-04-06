package org.example.price.domain.model.vo;

import org.apache.commons.lang3.StringUtils;
import org.example.price.domain.exceptions.InvalidPriceCurrencyException;
import org.example.shared.domain.vo.StringValueObject;

public class PriceCurrency extends StringValueObject {

    public PriceCurrency(String value) throws InvalidPriceCurrencyException {
        super(value);
        check(value);
    }

    public PriceCurrency() {
        super("EUR");
    }

    private void check(String value) throws InvalidPriceCurrencyException {
        if (StringUtils.isEmpty(value)) {
            throw new InvalidPriceCurrencyException();
        }
    }
}
