package co.favelezr.highspring.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Item(String name, ItemCategory category, BigDecimal price, int quantity) {
    public Item {
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Price must be non-negative");
        if (quantity < 1)
            throw new IllegalArgumentException("Quantity must be at least 1");
    }

    public BigDecimal totalPriceAfterDiscount() {
        return totalPriceBeforeDiscount()
                .subtract(discountAmount())
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal totalPriceBeforeDiscount() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    private BigDecimal discountAmount() {
        return totalPriceBeforeDiscount()
                .multiply(category.discountRate())
                .setScale(2, RoundingMode.HALF_UP);
    }
}
