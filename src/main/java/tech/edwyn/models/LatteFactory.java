package tech.edwyn.models;

public class LatteFactory implements CoffeeAbstractFactory {

    private final CoffeeType coffeeType;
    private final int beans;
    private final int water;
    private final int milk;

    public LatteFactory(int beans, int water, int milk) {
        this.coffeeType = CoffeeType.LATTE;
        this.beans = beans;
        this.water = water;
        this.milk = milk;
    }

    @Override
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
