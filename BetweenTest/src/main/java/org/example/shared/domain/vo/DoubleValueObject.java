package org.example.shared.domain.vo;

import java.io.Serializable;

public class DoubleValueObject implements Serializable {

    private final Double value;

    public DoubleValueObject(Double value) {
        this.value = value;
    }

    public DoubleValueObject() {
        this.value = null;
    }

    public Double value() {
        return value;
    }
}
