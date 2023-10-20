package tech.edwyn.models;

import java.util.List;


public final class Espresso extends Coffee {

    public Espresso() {
        super(CoffeeType.ESPRESSO, List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 37, Unit.ML)));
    }
}
