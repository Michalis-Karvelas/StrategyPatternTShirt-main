package models;

public enum Color {
    RED(0.04), ORANGE(0.05), YELLOW(0.06), GREEN(0.07), BLUE(0.08), INDIGO(0.09), VIOLET(0.1);

    private final double colorPrice;

    Color(double colorPrice){
        this.colorPrice=colorPrice;
    }

    public double getColorPrice() {
        return colorPrice;
    }
}
