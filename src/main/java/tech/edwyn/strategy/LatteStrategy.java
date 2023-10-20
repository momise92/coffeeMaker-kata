package tech.edwyn.strategy;

import tech.edwyn.models.Coffee;
import tech.edwyn.models.Ingredient;
import tech.edwyn.models.enums.CoffeeType;
import tech.edwyn.models.Latte;
import tech.edwyn.models.enums.IngredientName;
import tech.edwyn.models.enums.Unit;

import java.util.List;

public class LatteStrategy implements MakeCoffeeStrategy {

    @Override
    public Coffee createCoffee(CoffeeType coffeeType, List<Ingredient> ingredients) {
        if (!isValid(coffeeType, ingredients)) {
            throw new IllegalArgumentException("Ingredients is not valid");
        }
        return new Latte();
    }

    private boolean isValid(CoffeeType coffeeType, List<Ingredient> ingredients) {
        return coffeeType.equals(CoffeeType.LATTE)
                && ingredientInListIsValid(ingredients, IngredientName.BEANS, 7, Unit.GR)
                && ingredientInListIsValid(ingredients, IngredientName.WATER, 37, Unit.ML)
                && ingredientInListIsValid(ingredients, IngredientName.MILK, 170, Unit.ML);
    }

    private boolean ingredientInListIsValid(List<Ingredient> ingredients, IngredientName name, int quantity, Unit unit) {
        return ingredients.stream().anyMatch(i -> i.getName().equals(name) && i.getQuantity() == quantity && i.getUnit().equals(unit));
    }

}
