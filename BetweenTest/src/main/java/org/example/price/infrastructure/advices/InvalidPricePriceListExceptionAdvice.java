package org.example.price.infrastructure.advices;

import org.example.price.domain.exceptions.InvalidPriceEndDateException;
import org.example.price.domain.exceptions.InvalidPricePriceListException;
import org.example.shared.domain.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class InvalidPricePriceListExceptionAdvice {

    @ExceptionHandler(InvalidPricePriceListException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPricePriceListException() {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), HttpStatus.BAD_REQUEST.value(), "feedback.api.error", "invalid.price.priceList");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
