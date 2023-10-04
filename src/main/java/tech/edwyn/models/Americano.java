package tech.edwyn.models;

import java.util.List;

public class Americano extends Coffee {


    public Americano() {
        super(CoffeeType.AMERICANO, List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 100, Unit.ML)));
    }
}
