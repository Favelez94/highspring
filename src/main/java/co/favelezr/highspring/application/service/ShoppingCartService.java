package co.favelezr.highspring.application.service;

import co.favelezr.highspring.domain.adapter.gateway.ItemRepository;
import co.favelezr.highspring.domain.adapter.usecase.CalculateCartTotalUseCase;
import co.favelezr.highspring.domain.model.Item;
import co.favelezr.highspring.domain.model.ShoppingCart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ShoppingCartService implements CalculateCartTotalUseCase {
    private static final BigDecimal TAX_RATE = new BigDecimal("0.085"); // 8.5%
    private final ItemRepository itemRepository;

    public ShoppingCartService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ShoppingCart calculate() {
        List<Item> items = itemRepository.findAll();
        BigDecimal subtotal = items.stream()
                .map(Item::totalPriceAfterDiscount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal tax = subtotal.multiply(TAX_RATE).setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = subtotal.add(tax).setScale(2, RoundingMode.HALF_UP);

        return new ShoppingCart(subtotal, tax, total);
    }
}
