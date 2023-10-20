package tech.edwyn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.edwyn.models.*;

import java.util.List;


public class CoffeeMakerTest {

    @Test
    public void shouldMakeCoffeeWithEspressoIngredient() {

        // given
        Coffee espresso = new Espresso();
        List<Ingredient> ingredients = List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 37, Unit.ML));

        String result = "Coffee{coffeeType=ESPRESSO, ingredients=[Ingredient{name='BEANS', quantity=7, unit=GR}, Ingredient{name='WATER', quantity=37, unit=ML}]}";
        // when
        espresso = espresso.createCoffee(CoffeeType.ESPRESSO, ingredients);

        //then
        Assertions.assertEquals(result, espresso.toString());
    }

    @Test
    public void shouldThrowExceptionWithCoffeeInvalidIngredient() {

        // given
        Coffee espresso = new Espresso();
        List<Ingredient> ingredients = List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 347, Unit.ML));
        // when
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> espresso.createCoffee(CoffeeType.ESPRESSO, ingredients));

        //then
        Assertions.assertEquals("Ingredients is not valid", thrown.getMessage());
    }

    @Test
    public void shouldMakeCoffeeWithAmericanoIngredient() {

        // given
        Coffee coffee = new Americano();

        List<Ingredient> ingredients = List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 100, Unit.ML));

        String result = "Coffee{coffeeType=AMERICANO, ingredients=[Ingredient{name='BEANS', quantity=7, unit=GR}, Ingredient{name='WATER', quantity=100, unit=ML}]}";
        // when
        coffee = coffee.createCoffee(CoffeeType.AMERICANO, ingredients);

        //then
        Assertions.assertEquals(result, coffee.toString());
    }


    @Test
    public void shouldMakeCoffeeWithLatteIngredient() {

        // given
        Coffee latte = new Latte();

        List<Ingredient> ingredients = List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 37, Unit.ML),
                new Ingredient(IngredientName.MILK, 170, Unit.ML));

        String result = "Coffee{coffeeType=LATTE, ingredients=[Ingredient{name='beans', quantity=7, unit=GR}, " +
                "Ingredient{name='WATER', quantity=37, unit=ML}, " +
                "Ingredient{name='MILK', quantity=170, unit=ML}]}";

        // when
        latte = latte.createCoffee(CoffeeType.LATTE, ingredients);

        //then
        Assertions.assertTrue(result.equalsIgnoreCase(latte.toString()));
    }
}
