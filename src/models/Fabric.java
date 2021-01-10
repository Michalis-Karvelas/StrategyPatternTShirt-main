package models;

public enum Fabric {
    WOOL(12.0), COTTON(14.0), POLYESTER(15.0),  RAYON(20.0),
    LINEN(25.0),  CASHMERE(35.0),  SILK(50.0);
    
    private final double unitPrice;
    
    Fabric(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    
    
    
    
}
