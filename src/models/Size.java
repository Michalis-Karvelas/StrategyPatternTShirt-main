package models;

public enum Size {
    XS(0.0), S(0.05), M(0.1), L(0.15), XL(0.2), XXL(0.25), XXXL(0.3);

    private final double sizePrice;
    Size(double sizePrice) {
        this.sizePrice=sizePrice;
    }

    public double getSizePrice() {
        return sizePrice;
    }
}
