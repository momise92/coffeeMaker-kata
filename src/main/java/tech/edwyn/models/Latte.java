package tech.edwyn.models;

import java.util.List;

public class Latte extends Coffee {
    public Latte() {
        super();
    }

    public Latte(CoffeeType coffeeType, List<Ingredient> ingredients) {
        super(coffeeType, ingredients);
    }

    @Override
    public Coffee createCoffee(CoffeeType coffeeType, List<Ingredient> ingredients) {
        if(!isValid(coffeeType, ingredients)) {
            throw new IllegalArgumentException("Ingredients is not valid");
        }
        return new Americano(coffeeType, ingredients);
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
