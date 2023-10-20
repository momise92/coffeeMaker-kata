package tech.edwyn.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkMaker {
    private CoffeeType coffeeType;
    private List<Ingredient> ingredientList;


    public Coffee makeCoffee(MakeCoffeeStrategy makeCoffeeStrategy) {
        return makeCoffeeStrategy.createCoffee(coffeeType, ingredientList);
    }
}
