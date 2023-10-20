package tech.edwyn;

import tech.edwyn.models.Coffee;
import tech.edwyn.models.MakeCoffeeStrategy;

public interface CoffeeMaker {

    Coffee makeCoffee(MakeCoffeeStrategy makeCoffeeStrategy);
}
