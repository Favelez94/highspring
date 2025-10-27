package co.favelezr.highspring.application.service;

import co.favelezr.highspring.domain.adapter.gateway.ItemRepository;
import co.favelezr.highspring.domain.adapter.usecase.CalculateCartTotalUseCase;
import co.favelezr.highspring.domain.model.Item;
import co.favelezr.highspring.domain.model.ShoppingCart;

import java.util.List;

public class ShoppingCartService implements CalculateCartTotalUseCase {
    private static final double SALES_TAX_RATE = 0.085; // 8.5%
    private final ItemRepository itemRepository;

    public ShoppingCartService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ShoppingCart calculate() {
        List<Item> items = itemRepository.findAll();

        double subtotal = items.stream()
                .mapToDouble(Item::subtotalAfterDiscount)
                .sum();

        double tax = subtotal * SALES_TAX_RATE;
        double total = subtotal + tax;

        return new ShoppingCart(round(subtotal), round(tax), round(total));
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
