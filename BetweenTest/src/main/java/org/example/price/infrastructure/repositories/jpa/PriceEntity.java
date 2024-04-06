package org.example.price.infrastructure.repositories.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "price")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {

    private String id;
    @Column(name = "brand_id", nullable = false)
    private Integer brandId;
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;
    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;
    @Column(name = "price_list", nullable = false)
    private Integer priceList;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "priority", nullable = false)
    private Integer priority;
    @Column(name = "price", nullable = false)
    private Double finalPrice;
    @Column(name = "curr", nullable = false)
    private String currency;

    public static
}
