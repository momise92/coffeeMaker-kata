package tech.edwyn;

import tech.edwyn.models.Coffee;
import tech.edwyn.models.CoffeeAbstractFactory;

public interface CoffeeMaker {

    Coffee makeCoffee(CoffeeAbstractFactory coffeeAbstractFactory);
}
