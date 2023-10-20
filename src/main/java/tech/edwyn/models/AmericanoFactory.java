package tech.edwyn.models;

public class AmericanoFactory implements CoffeeAbstractFactory {

    private final CoffeeType coffeeType;
    private final int beans;
    private final int water;

    public AmericanoFactory(int beans, int water) {
        this.coffeeType = CoffeeType.AMERICANO;
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
