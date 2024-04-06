package org.example.price.domain.model.vo;

import org.example.price.domain.exceptions.InvalidPricePriceListException;
import org.example.shared.domain.vo.IntegerValueObject;

import java.util.Objects;

public class PricePriceList extends IntegerValueObject {

    public PricePriceList(Integer value) throws InvalidPricePriceListException {
        super(value);
        check(value);
    }

    public PricePriceList() {
        super(0);
    }

    private void check(Integer value) throws InvalidPricePriceListException {
        if (Objects.isNull(value)) {
            throw new InvalidPricePriceListException();
        }
    }
}
