package org.example.price.infrastructure.advices;

import org.example.price.domain.exceptions.InvalidPriceIdException;
import org.example.price.domain.exceptions.InvalidPriceInputDateException;
import org.example.shared.domain.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class InvalidPriceInputDateExceptionAdvice {

    @ExceptionHandler(InvalidPriceInputDateException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPriceIdException() {
        ErrorResponse errorResponse = new ErrorResponse(new Date(), HttpStatus.BAD_REQUEST.value(), "invalid.price.inputDate", "The allowed pattern for startDate is \"yyyy-MM-dd-HH.mm.ss\"");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
