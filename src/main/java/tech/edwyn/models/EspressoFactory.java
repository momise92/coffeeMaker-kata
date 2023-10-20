package tech.edwyn.models;

public class EspressoFactory implements CoffeeAbstractFactory {

    private CoffeeType coffeeType;
    private final int beans;
    private final int water;

    public EspressoFactory(int beans, int water) {
        this.coffeeType = CoffeeType.ESPRESSO;
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
        return coffeeType.equals(CoffeeType.ESPRESSO) && beans == 7 && water == 37;
    }
}
