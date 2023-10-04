package tech.edwyn.models;

public class EspressoFactory implements CoffeeAbstractFactory {

    private CoffeeType coffeeType;
    private int beans;
    private int water;

    public EspressoFactory(CoffeeType coffeeType, int beans, int water) {
        this.coffeeType = coffeeType;
        this.beans = beans;
        this.water = water;
    }

    @Override
    public Coffee createCoffee() {
        if(!isValid()) {
          throw  new IllegalArgumentException("Ingredients is not valid");
        }
        return new Espresso();
    }


    private boolean isValid() {
        if (coffeeType.equals(CoffeeType.ESPRESSO) && beans == 7 && water == 37) {
            return true;
        }
        return false;
    }
}
