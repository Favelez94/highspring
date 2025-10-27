package co.favelezr.highspring.domain.model;

public enum ItemCategory {

    ELECTRONICS(0.10),
    CLOTHING(0.15),
    BOOKS(0.05),
    FOOD(0.02);

    private final double discountRate;

    ItemCategory(double discountRate) {
        this.discountRate = discountRate;
    }

    public double discountRate() {
        return discountRate;
    }
}
