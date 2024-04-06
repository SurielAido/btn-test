package price.infrastructure;

import lombok.SneakyThrows;
import org.example.price.application.FindPriceFromStartDateProductIdAndBrandIdService;
import org.example.price.infrastructure.responses.PriceResponse;
import org.example.price.infrastructure.rest.FindPriceFromStartDateProductIdAndBrandIdController;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import price.domain.PriceMother;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static price.shared.ResponseBodyMatchers.responseBody;

@RunWith(SpringRunner.class)
@WebMvcTest(FindPriceFromStartDateProductIdAndBrandIdController.class)
@ContextConfiguration(classes = {FindPriceFromStartDateProductIdAndBrandIdController.class})
public class FindPriceByStartDateProductIdAndBrandIdControllerTest {

    private static final String URL = "/price";

    @MockBean
    private FindPriceFromStartDateProductIdAndBrandIdService findPriceFromStartDateProductIdAndBrandIdService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @SneakyThrows
    @DisplayName("Debe devolver una lista de pricesResponse en funcion de unos parámetros dados")
    public void shouldReturnsPricesResponseListFromSearch() {
        List<PriceResponse> responses = PriceResponse.toResponseList(PriceMother.getRandomList(3));

        when(findPriceFromStartDateProductIdAndBrandIdService.findPriceFromStartDateProductIdAndBrandId(any(ZonedDateTime.class), anyLong(), anyInt())).thenReturn(responses);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("startdate", "2020-06-14-00.00.00");
        params.add("productid", "35455");
        params.add("brandid", "1");

        mockMvc.perform(get(URL).params(params)).andExpect(status().isOk()).andExpect(responseBody().containsObjectAsJson(responses, ArrayList.class));
    }

    @Test
    @SneakyThrows
    @DisplayName("Debe devolver una un 400 porque no tiene la start date")
    public void shouldReturns400BecauseStartDateIsEmpty() {
        List<PriceResponse> responses = PriceResponse.toResponseList(PriceMother.getRandomList(3));

        when(findPriceFromStartDateProductIdAndBrandIdService.findPriceFromStartDateProductIdAndBrandId(any(ZonedDateTime.class), anyLong(), anyInt())).thenReturn(responses);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("productid", "35455");
        params.add("brandid", "1");

        mockMvc.perform(get(URL).params(params)).andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    @DisplayName("Debe devolver una un 400 porque no tiene el productId")
    public void shouldReturns400BecauseProductIdIsEmpty() {
        List<PriceResponse> responses = PriceResponse.toResponseList(PriceMother.getRandomList(3));

        when(findPriceFromStartDateProductIdAndBrandIdService.findPriceFromStartDateProductIdAndBrandId(any(ZonedDateTime.class), anyLong(), anyInt())).thenReturn(responses);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("startdate", "2020-06-14-00.00.00");
        params.add("brandid", "1");

        mockMvc.perform(get(URL).params(params)).andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    @DisplayName("Debe devolver una un 400 porque no tiene la brandId")
    public void shouldReturns400BecauseBrandIdIsEmpty() {
        List<PriceResponse> responses = PriceResponse.toResponseList(PriceMother.getRandomList(3));

        when(findPriceFromStartDateProductIdAndBrandIdService.findPriceFromStartDateProductIdAndBrandId(any(ZonedDateTime.class), anyLong(), anyInt())).thenReturn(responses);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("startdate", "2020-06-14-00.00.00");
        params.add("productid", "35455");

        mockMvc.perform(get(URL).params(params)).andExpect(status().isBadRequest());
    }

}
