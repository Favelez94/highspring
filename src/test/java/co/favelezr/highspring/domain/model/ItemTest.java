package co.favelezr.highspring.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    void shouldApplyDiscountForElectronics() {
        Item laptop = new Item("Laptop", ItemCategory.ELECTRONICS, new BigDecimal("1000.00"), 1);
        BigDecimal expected = new BigDecimal("900.00"); // 10% discount
        assertEquals(expected, laptop.totalPriceAfterDiscount());
    }

    @Test
    void shouldApplyDiscountForClothing() {
        Item tshirt = new Item("T-shirt", ItemCategory.CLOTHING, new BigDecimal("50.00"), 2);
        BigDecimal expected = new BigDecimal("85.00"); // 15% discount on 100
        assertEquals(expected, tshirt.totalPriceAfterDiscount());
    }

    @Test
    void shouldApplyDiscountForBooks() {
        Item book = new Item("Book", ItemCategory.BOOKS, new BigDecimal("100.00"), 1);
        BigDecimal expected = new BigDecimal("95.00"); // 5% discount
        assertEquals(expected, book.totalPriceAfterDiscount());
    }

    @Test
    void shouldApplyDiscountForFood() {
        Item coffee = new Item("Coffee", ItemCategory.FOOD, new BigDecimal("10.00"), 5);
        BigDecimal expected = new BigDecimal("49.00"); // 2% discount on 50
        assertEquals(expected, coffee.totalPriceAfterDiscount());
    }
}