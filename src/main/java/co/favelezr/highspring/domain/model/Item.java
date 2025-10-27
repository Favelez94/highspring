package co.favelezr.highspring.domain.model;

public record Item(String name, ItemCategory category, double price, int quantity) {
    public double subtotalBeforeDiscount() {
        return price * quantity;
    }

    public double discountAmount() {
        return subtotalBeforeDiscount() * category.discountRate();
    }

    public double subtotalAfterDiscount() {
        return subtotalBeforeDiscount() - discountAmount();
    }
}
