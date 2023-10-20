package tech.edwyn.models;

import java.util.List;

public interface MakeCoffeeStrategy {

    Coffee createCoffee(CoffeeType coffeeType, List<Ingredient> ingredients);
}
