package co.favelezr.highspring;

import co.favelezr.highspring.application.service.ShoppingCartService;
import co.favelezr.highspring.domain.adapter.gateway.ItemRepository;
import co.favelezr.highspring.domain.model.ShoppingCart;
import co.favelezr.highspring.infrastructure.repository.InMemoryItemRepository;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, High Spring!");
        ItemRepository repository = new InMemoryItemRepository();
        var service = new ShoppingCartService(repository);

        ShoppingCart totals = service.calculate();

        print(totals);
    }

    private static void print(ShoppingCart totals) {
        System.out.println("🛒 Shopping Cart Totals");
        System.out.println("------------------------");
        System.out.printf("Subtotal (after discounts): $%.2f%n", totals.subtotal());
        System.out.printf("Tax (8.5%%):                $%.2f%n", totals.tax());
        System.out.printf("Total:                     $%.2f%n", totals.total());
    }
}
