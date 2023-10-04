package tech.edwyn.models;

import tech.edwyn.CoffeeMaker;

public class DrinkMaker implements CoffeeMaker {


    @Override
    public Coffee makeCoffee(CoffeeAbstractFactory coffeeAbstractFactory) {
        return coffeeAbstractFactory.createCoffee();
    }
}
