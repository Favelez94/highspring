package co.favelezr.highspring.infrastructure.repository;

import co.favelezr.highspring.domain.adapter.gateway.ItemRepository;
import co.favelezr.highspring.domain.model.Item;
import co.favelezr.highspring.domain.model.ItemCategory;

import java.math.BigDecimal;
import java.util.List;

public class InMemoryItemRepository implements ItemRepository {
    @Override
    public List<Item> findAll() {
        return List.of(
                new Item("Laptop", ItemCategory.ELECTRONICS, new BigDecimal("2500.0"), 1),
                new Item("T-shirt", ItemCategory.CLOTHING, new BigDecimal("50.0"), 2),
                new Item("Book: Clean Code", ItemCategory.BOOKS, new BigDecimal("100.0"), 1),
                new Item("Coffee (pack)", ItemCategory.FOOD, new BigDecimal("10.0"), 5)
        );
    }
}
