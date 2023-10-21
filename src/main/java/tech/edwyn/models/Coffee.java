package tech.edwyn.models;

import tech.edwyn.models.enums.CoffeeType;

import java.util.List;

/**
 * Expected coffee model.
 * Contains ingredients only.
 * As an example, an espresso will contain 7g of beans ingredient and 37ml of water ingredient.
 */
public abstract class Coffee {

    protected CoffeeType coffeeType;
    protected List<Ingredient> ingredients;

    public Coffee(CoffeeType coffeeType, List<Ingredient> ingredients) {
        this.coffeeType = coffeeType;
        this.ingredients = ingredients;
    }

    public abstract void make();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coffee{");
        sb.append("coffeeType=").append(coffeeType);
        sb.append(", ingredients=").append(ingredients);
        sb.append('}');
        return sb.toString();
    }
}
