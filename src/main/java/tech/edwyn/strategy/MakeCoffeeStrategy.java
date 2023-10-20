package tech.edwyn.strategy;

import tech.edwyn.models.Coffee;
import tech.edwyn.models.enums.CoffeeType;
import tech.edwyn.models.Ingredient;

import java.util.List;

public interface MakeCoffeeStrategy {

    /**
     * Make the chosen coffee
     * @param coffeeType - Type of coffee
     * @param ingredients - list of ingredient for coffee
     * @return Type of Coffee chosen
     */
    Coffee createCoffee(final CoffeeType coffeeType, final List<Ingredient> ingredients);
}
