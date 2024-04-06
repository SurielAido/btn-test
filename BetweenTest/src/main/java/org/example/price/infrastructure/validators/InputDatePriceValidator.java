package org.example.price.infrastructure.validators;

import org.example.price.domain.exceptions.InvalidPriceInputDateException;

public class InputDatePriceValidator {

    public static void inputDatePriceValidator(String inputDate) throws InvalidPriceInputDateException {
        if (inputDate.length() != 19 || !Character.isDigit(inputDate.charAt(0)) || !Character.isDigit(inputDate.charAt(1)) || !Character.isDigit(inputDate.charAt(2)) || !Character.isDigit(inputDate.charAt(3))
                || inputDate.charAt(4) != '-' || !Character.isDigit(inputDate.charAt(5)) || !Character.isDigit(inputDate.charAt(6)) || inputDate.charAt(7) != '-'
                || !Character.isDigit(inputDate.charAt(8)) || !Character.isDigit(inputDate.charAt(9)) || inputDate.charAt(10) != '-'
                || !Character.isDigit(inputDate.charAt(11)) || !Character.isDigit(inputDate.charAt(12)) || inputDate.charAt(13) != '.'
                || !Character.isDigit(inputDate.charAt(14)) || !Character.isDigit(inputDate.charAt(15)) || inputDate.charAt(16) != '.'
                || !Character.isDigit(inputDate.charAt(17)) || !Character.isDigit(inputDate.charAt(18))
        ) {
            throw new InvalidPriceInputDateException();
        }
    }
}
