package co.favelezr.highspring.domain.model;

import java.math.BigDecimal;

public record ShoppingCart(BigDecimal subtotal, BigDecimal tax, BigDecimal total) {
}
