package tech.edwyn.models;

import lombok.AllArgsConstructor;
import tech.edwyn.CoffeeMaker;
import tech.edwyn.models.enums.CoffeeType;
import tech.edwyn.strategy.MakeCoffeeStrategy;

import java.util.List;


@AllArgsConstructor
public class DrinkMaker implements CoffeeMaker {
    private CoffeeType coffeeType;
    private List<Ingredient> ingredientList;

    @Override
    public Coffee makeCoffee(MakeCoffeeStrategy makeCoffeeStrategy) {
        return makeCoffeeStrategy.createCoffee(coffeeType, ingredientList);
    }
}
