package co.favelezr.highspring.domain.model;

import java.math.BigDecimal;

public enum ItemCategory {

    ELECTRONICS(new BigDecimal("0.10")),
    CLOTHING(new BigDecimal("0.15")),
    BOOKS(new BigDecimal("0.05")),
    FOOD(new BigDecimal("0.02"));

    private final BigDecimal discountRate;

    ItemCategory(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public BigDecimal discountRate() {
        return discountRate;
    }
}
