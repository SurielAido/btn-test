package org.example.price.infrastructure.advices;

import org.example.price.domain.exceptions.InvalidPriceBrandIdException;
import org.example.price.domain.exceptions.InvalidPriceFinalPriceException;
import org.example.shared.domain.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class InvalidPriceFinalPriceExceptionAdvice {

    @ExceptionHandler(InvalidPriceFinalPriceException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPriceFinalPriceException() {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), HttpStatus.BAD_REQUEST.value(), "feedback.api.error", "invalid.price.finalPrice");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
