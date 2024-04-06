package price.shared;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.price.infrastructure.responses.PriceResponse;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponseBodyMatchers {

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> ResultMatcher containsObjectAsJson(Object expectedObject,
                                                  Class<T> targetClass) {
        return mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            T actualObject = objectMapper.readValue(json, targetClass);
            List<PriceResponse> responses = castToResponses((List<LinkedHashMap<String, Object>>) actualObject);
            compareObjectFieldByField(((List<PriceResponse>) expectedObject).get(0), responses.get(0));
            compareObjectFieldByField(((List<PriceResponse>) expectedObject).get(1), responses.get(1));
            compareObjectFieldByField(((List<PriceResponse>) expectedObject).get(2), responses.get(2));
        };
    }

    private void compareObjectFieldByField(PriceResponse expectedResponse, PriceResponse actualResponse) {
        assertEquals(expectedResponse.getBrandId(), actualResponse.getBrandId());
        assertEquals(expectedResponse.getStartDate(), actualResponse.getStartDate());
        assertEquals(expectedResponse.getEndDate(), actualResponse.getEndDate());
        assertEquals(expectedResponse.getPriceList(), actualResponse.getPriceList());
        assertEquals(expectedResponse.getProductId(), actualResponse.getProductId());
        assertEquals(expectedResponse.getPriority(), actualResponse.getPriority());
        assertEquals(expectedResponse.getFinalPrice(), actualResponse.getFinalPrice());
        assertEquals(expectedResponse.getCurrency(), actualResponse.getCurrency());
    }

    private List<PriceResponse> castToResponses(List<LinkedHashMap<String, Object>> paramMapList) {
        List<PriceResponse> prices = new ArrayList<>();
        for (LinkedHashMap<String, Object> map : paramMapList) {
            prices.add(
                    new PriceResponse(
                            (Integer) map.get("brandId"),
                            ZonedDateTime.parse((String) map.get("startDate")).withZoneSameInstant(ZoneId.systemDefault()),
                            ZonedDateTime.parse((String) map.get("endDate")).withZoneSameInstant(ZoneId.systemDefault()),
                            (Integer) map.get("priceList"),
                            new Long((Integer) map.get("productId")),
                            (Integer) map.get("priority"),
                            (Double) map.get("finalPrice"),
                            (String) map.get("currency")
                    )
            );
        }
        return prices;
    }

    public static ResponseBodyMatchers responseBody() {
        return new ResponseBodyMatchers();
    }
}
