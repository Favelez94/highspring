package co.favelezr.highspring.application.service;

import co.favelezr.highspring.domain.adapter.gateway.ItemRepository;
import co.favelezr.highspring.domain.model.ShoppingCart;
import co.favelezr.highspring.infrastructure.repository.InMemoryItemRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShoppingCartServiceTest {

    @Test
    void shouldCalculateSubtotalTaxAndTotalCorrectly() {
        ItemRepository repo = new InMemoryItemRepository();
        ShoppingCartService service = new ShoppingCartService(repo);

        ShoppingCart cart = service.calculate();

        // Expected values from manual calculation
        assertEquals(new BigDecimal("2479.00"), cart.subtotal());
        assertEquals(new BigDecimal("210.72"), cart.tax());
        assertEquals(new BigDecimal("2689.72"), cart.total());
    }

    @Test
    void shouldHandleEmptyCart() {
        ItemRepository emptyRepo = Collections::emptyList;
        ShoppingCartService service = new ShoppingCartService(emptyRepo);

        ShoppingCart cart = service.calculate();

        assertEquals(0, cart.subtotal().compareTo(BigDecimal.ZERO));
        assertEquals(0, cart.tax().compareTo(BigDecimal.ZERO));
        assertEquals(0, cart.total().compareTo(BigDecimal.ZERO));
    }
}