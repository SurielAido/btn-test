package org.example.price.domain.model.vo;

import org.example.price.domain.exceptions.InvalidPriceBrandIdException;
import org.example.price.domain.exceptions.InvalidPricePriorityException;
import org.example.shared.domain.vo.IntegerValueObject;

import java.util.Objects;

public class PricePriority extends IntegerValueObject {

    public PricePriority(Integer value) throws InvalidPricePriorityException {
        super(value);
        check(value);
    }

    public PricePriority() { super(0);}

    private void check(Integer value) throws InvalidPricePriorityException {
        if (Objects.isNull(value)) {
            throw new InvalidPricePriorityException();
        }
    }
}
