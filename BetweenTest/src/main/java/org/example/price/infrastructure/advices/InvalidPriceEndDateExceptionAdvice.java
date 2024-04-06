package org.example.price.infrastructure.advices;

import org.example.price.domain.exceptions.InvalidPriceCurrencyException;
import org.example.price.domain.exceptions.InvalidPriceEndDateException;
import org.example.shared.domain.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class InvalidPriceEndDateExceptionAdvice {

    @ExceptionHandler(InvalidPriceEndDateException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPriceEndDateException() {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), HttpStatus.BAD_REQUEST.value(), "feedback.api.error", "invalid.price.endDate");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
