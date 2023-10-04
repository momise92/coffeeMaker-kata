package tech.edwyn.models;

import java.util.List;

public class Latte extends Coffee {
    public Latte() {
        super(CoffeeType.LATTE, List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 37, Unit.ML), new Ingredient(IngredientName.MILK, 170, Unit.ML)));
    }
}
