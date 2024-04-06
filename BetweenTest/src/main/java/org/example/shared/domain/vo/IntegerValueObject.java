package org.example.shared.domain.vo;

import java.io.Serializable;

public class IntegerValueObject implements Serializable {

    private final Integer value;

    public IntegerValueObject(Integer value) {
        this.value = value;
    }

    public IntegerValueObject() {
        this.value = null;
    }

    public Integer value() {
        return value;
    }
}
