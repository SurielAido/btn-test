package org.example.shared.domain.vo;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class StringValueObject implements Serializable {

    private final String value;

    public StringValueObject(String value) {
        this.value = value;
    }

    public StringValueObject() {
        this.value = null;
    }

    public String value() {
        return value;
    }
}
