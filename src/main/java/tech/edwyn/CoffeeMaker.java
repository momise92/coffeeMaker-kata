package tech.edwyn;

import tech.edwyn.models.Coffee;
import tech.edwyn.strategy.MakeCoffeeStrategy;

public interface CoffeeMaker {

    Coffee makeCoffee(MakeCoffeeStrategy makeCoffeeStrategy);
}
