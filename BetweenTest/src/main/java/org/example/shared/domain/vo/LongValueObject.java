package org.example.shared.domain.vo;

import java.io.Serializable;

public class LongValueObject implements Serializable {

    private final Long value;

    public LongValueObject(Long value) {
        this.value = value;
    }

    public LongValueObject() {
        this.value = null;
    }

    public Long value() {
        return value;
    }
}
