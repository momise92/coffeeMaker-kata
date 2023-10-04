package tech.edwyn.models;

public class AmericanoFactory implements CoffeeAbstractFactory {

    private CoffeeType coffeeType;
    private int beans;
    private int water;

    public AmericanoFactory(CoffeeType coffeeType, int beans, int water) {
        this.coffeeType = coffeeType;
        this.beans = beans;
        this.water = water;
    }

    @Override
    public Coffee createCoffee() {
        if(!isValid()) {
            throw new IllegalArgumentException("Ingredients is not valid");
        }
        return new Americano();
    }


    private boolean isValid() {
        if (coffeeType.equals(CoffeeType.AMERICANO) && beans == 7 && water == 100) {
            return true;
        }
        return false;
    }

}
