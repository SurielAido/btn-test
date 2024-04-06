package org.example.price.infrastructure.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.price.application.FindPriceFromStartDateProductIdAndBrandIdService;
import org.example.price.domain.exceptions.PriceException;
import org.example.price.infrastructure.responses.PriceResponse;
import org.example.price.infrastructure.validators.InputDatePriceValidator;
import org.example.shared.domain.vo.ZonedDateTimeValueObject;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/price")
public class FindPriceFromStartDateProductIdAndBrandIdController {

    private FindPriceFromStartDateProductIdAndBrandIdService findPriceFromStartDateProductIdAndBrandIdService;

    @GetMapping
    public @ResponseBody List<PriceResponse> findPriceFromStartDateProductIdAndBrandId(@RequestParam("startdate") String startDate,
                                                                                       @RequestParam("productid") Long productId,
                                                                                       @RequestParam("brandid") Integer brandId) throws PriceException {
        log.info("GET /price endpoint has been called");
        InputDatePriceValidator.inputDatePriceValidator(startDate);
        ZonedDateTime startDateAsZDT = ZonedDateTimeValueObject.castStringToZonedDateTime(startDate);
        return findPriceFromStartDateProductIdAndBrandIdService.findPriceFromStartDateProductIdAndBrandId(startDateAsZDT, productId, brandId);
    }
}
