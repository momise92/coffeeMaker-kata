package tech.edwyn.models;

import tech.edwyn.models.enums.CoffeeType;
import tech.edwyn.models.enums.IngredientName;
import tech.edwyn.models.enums.Unit;

import java.util.List;

public final class Americano extends Coffee {

    public Americano() {
        super(CoffeeType.AMERICANO, List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 100, Unit.ML)));

    }


}
