package tech.edwyn.models;

public class LatteFactory {

    private CoffeeType coffeeType;
    private int beans;
    private int water;
    private int milk;

    public LatteFactory(CoffeeType coffeeType, int beans, int water, int milk) {
        this.coffeeType = coffeeType;
        this.beans = beans;
        this.water = water;
        this.milk = milk;
    }

    public Coffee createCoffee() {
        if(!isValid()) {
            throw new IllegalArgumentException("Ingredients is not valid");
        }
        return new Latte();
    }


    private boolean isValid() {
        if (coffeeType.equals(CoffeeType.LATTE) && beans == 7 && water == 37 && milk == 170) {
            return true;
        }
        return false;
    }
}
