package org.example.price.domain.model.vo;

import org.example.price.domain.exceptions.InvalidPriceBrandIdException;
import org.example.shared.domain.vo.IntegerValueObject;

import java.util.Objects;

public class PriceBrandId extends IntegerValueObject {

    public PriceBrandId(Integer value) throws InvalidPriceBrandIdException {
        super(value);
        check(value);
    }

    public PriceBrandId() { super(0);}

    private void check(Integer value) throws InvalidPriceBrandIdException {
        if (Objects.isNull(value)) {
            throw new InvalidPriceBrandIdException();
        }
    }
}
