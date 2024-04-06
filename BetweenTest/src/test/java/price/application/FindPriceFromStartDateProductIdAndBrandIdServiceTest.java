package price.application;

import lombok.SneakyThrows;
import org.example.price.application.FindPriceFromStartDateProductIdAndBrandIdService;
import org.example.price.domain.model.Price;
import org.example.price.domain.repositories.PriceRepository;
import org.example.price.infrastructure.responses.PriceResponse;
import org.example.shared.domain.vo.ZonedDateTimeValueObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import price.domain.PriceMother;

import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindPriceFromStartDateProductIdAndBrandIdServiceTest {

    @InjectMocks
    private FindPriceFromStartDateProductIdAndBrandIdService findPriceFromStartDateProductIdAndBrandIdService;

    @Mock
    private PriceRepository priceRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @SneakyThrows
    @DisplayName("Debe devolver los precios filtrando por startDate, brandId y productId")
    public void shouldReturnsPricesFilteringByStartDateBrandIdAndProduct() {
        ZonedDateTime zonedDateTime = ZonedDateTimeValueObject.castStringToZonedDateTime("2020-06-14-00.00.00");
        Long productId = 35455L;
        Integer brandId = 1;
        List<Price> prices = PriceMother.getRandomList(3);

        when(priceRepository.findPricesByStartDateProductIdAndBrandId(any(ZonedDateTime.class), anyLong(), anyInt())).thenReturn(prices);

        List<PriceResponse> responses = findPriceFromStartDateProductIdAndBrandIdService.findPriceFromStartDateProductIdAndBrandId(zonedDateTime, productId, brandId);

        assertNotNull(responses);
        assertEquals(prices.size(), responses.size());
        assertEquals(prices.get(0).getFinalPrice().value(), responses.get(0).getFinalPrice());
    }
}
