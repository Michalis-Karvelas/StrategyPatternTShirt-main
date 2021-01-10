package models;

public class RandomTShirt extends TShirt {

    public RandomTShirt(String newname) {
        super();
        this.setName(newname);
        this.setSize(Size.values()[getRandomNumber(0, 6)]);
        this.setColor(Color.values()[getRandomNumber(0, 6)]);
        this.setFabric(Fabric.values()[getRandomNumber(0, 6)]);
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
