package tech.edwyn.strategy;

import tech.edwyn.models.Coffee;
import tech.edwyn.models.Ingredient;
import tech.edwyn.models.enums.CoffeeType;
import tech.edwyn.models.Latte;
import tech.edwyn.models.enums.IngredientName;
import tech.edwyn.models.enums.Unit;

import java.util.ArrayList;
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
        List<Ingredient> copyIngredients =  new ArrayList<>(ingredients);
        ingredientInListIsValid(copyIngredients, IngredientName.BEANS, 7, Unit.GR);
        ingredientInListIsValid(copyIngredients, IngredientName.WATER, 37, Unit.ML);
        ingredientInListIsValid(copyIngredients, IngredientName.MILK, 170, Unit.ML);

        return coffeeType.equals(CoffeeType.LATTE) && copyIngredients.isEmpty();
    }

    private void ingredientInListIsValid(List<Ingredient> ingredients, IngredientName name, int quantity, Unit unit) {
        ingredients.removeIf(i -> i.getName().equals(name) && i.getQuantity() == quantity && i.getUnit().equals(unit));
    }

}
