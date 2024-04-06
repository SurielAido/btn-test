package org.example.price.domain.model;

import java.sql.Timestamp;

public class Price {

    private String id;
    private Integer brandId;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer priceList;
    private Long productId;
    private Integer priority;
    private Double finalPrice;
    private String currency;
}
