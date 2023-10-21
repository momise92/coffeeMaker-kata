package tech.edwyn.strategy;

import tech.edwyn.models.*;
import tech.edwyn.models.enums.CoffeeType;
import tech.edwyn.models.enums.IngredientName;
import tech.edwyn.models.enums.Unit;

import java.util.ArrayList;
import java.util.List;

public class EspressoStrategy implements MakeCoffeeStrategy {


    @Override
    public Coffee createCoffee(CoffeeType coffeeType, List<Ingredient> ingredients) {
        if(!isValid(coffeeType, ingredients)) {
          throw  new IllegalArgumentException("Ingredients is not valid");
        }
        return new Espresso();
    }

    private boolean isValid(CoffeeType coffeeType, List<Ingredient> ingredients) {
        List<Ingredient> copyIngredients =  new ArrayList<>(ingredients);
        ingredientInListIsValid(copyIngredients, IngredientName.BEANS, 7, Unit.GR);
        ingredientInListIsValid(copyIngredients, IngredientName.WATER, 37, Unit.ML);

        return coffeeType.equals(CoffeeType.ESPRESSO) && copyIngredients.isEmpty();
    }

    private void ingredientInListIsValid(List<Ingredient> ingredients, IngredientName name, int quantity, Unit unit) {
        ingredients.removeIf(i -> i.getName().equals(name) && i.getQuantity() == quantity && i.getUnit().equals(unit));
    }

}
