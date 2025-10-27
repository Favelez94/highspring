package co.favelezr.highspring.infrastructure.repository;

import co.favelezr.highspring.domain.adapter.gateway.ItemRepository;
import co.favelezr.highspring.domain.model.Item;
import co.favelezr.highspring.domain.model.ItemCategory;

import java.util.List;

public class InMemoryItemRepository implements ItemRepository {
    @Override
    public List<Item> findAll() {
        return List.of(
                new Item("Laptop", ItemCategory.ELECTRONICS, 2500.0, 1),
                new Item("T-shirt", ItemCategory.CLOTHING, 50.0, 2),
                new Item("Book: Clean Code", ItemCategory.BOOKS, 100.0, 1),
                new Item("Coffee (pack)", ItemCategory.FOOD, 10.0, 5)
        );
    }
}
