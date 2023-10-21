package tech.edwyn.models;

import tech.edwyn.models.enums.CoffeeType;
import tech.edwyn.models.enums.IngredientName;
import tech.edwyn.models.enums.Unit;

import java.util.ArrayList;
import java.util.List;

public class Americano extends Coffee {
    public Americano(List<Ingredient> ingredients) {
        super(CoffeeType.AMERICANO, ingredients);
    }

    public void make() {
        if(!isValid(ingredients)) {
            throw new IllegalArgumentException("Ingredients is not valid");
        }
    }

    private boolean isValid(List<Ingredient> ingredients) {
        List<Ingredient> copyIngredients = new ArrayList<>(ingredients);
        removeIfIngredientInList(copyIngredients, IngredientName.BEANS, 7, Unit.GR);
        removeIfIngredientInList(copyIngredients, IngredientName.WATER, 100, Unit.ML);

        return copyIngredients.isEmpty();
    }

    private void removeIfIngredientInList(List<Ingredient> ingredients, IngredientName name, int quantity, Unit unit) {
        ingredients.removeIf(i -> i.getName().equals(name) && i.getQuantity() == quantity && i.getUnit().equals(unit));
    }
}
