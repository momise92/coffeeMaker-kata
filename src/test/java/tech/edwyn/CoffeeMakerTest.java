package tech.edwyn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.edwyn.models.*;
import tech.edwyn.models.enums.IngredientName;
import tech.edwyn.models.enums.Unit;

import java.util.Arrays;
import java.util.List;


public class CoffeeMakerTest {

    @Test
    public void shouldMakeCoffeeWithEspressoIngredient() {

        // given
        List<Ingredient> ingredients = Arrays.asList(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 37, Unit.ML));

        Coffee espresso = new Espresso(ingredients);

        DrinkMaker drinkMaker = new DrinkMaker();

        String result = "Coffee{coffeeType=ESPRESSO, ingredients=[Ingredient{name='BEANS', quantity=7, unit=GR}, Ingredient{name='WATER', quantity=37, unit=ML}]}";
        // when
        drinkMaker.createCoffee(espresso);

        //then
        Assertions.assertEquals(result, espresso.toString());
    }

    @Test
    public void shouldThrowExceptionWithCoffeeInvalidIngredient() {

        // given
        List<Ingredient> ingredients = Arrays.asList(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 347, Unit.ML));

        Coffee espresso = new Espresso(ingredients);

        DrinkMaker drinkMaker = new DrinkMaker();
        // when
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> drinkMaker.createCoffee(espresso));

        //then
        Assertions.assertEquals("Ingredients is not valid", thrown.getMessage());
    }

    @Test
    public void shouldMakeCoffeeWithAmericanoIngredient() {

        // given
        List<Ingredient> ingredients = Arrays.asList(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 100, Unit.ML));

        Coffee americano = new Americano(ingredients);

        DrinkMaker drinkMaker = new DrinkMaker();

        String result = "Coffee{coffeeType=AMERICANO, ingredients=[Ingredient{name='BEANS', quantity=7, unit=GR}, Ingredient{name='WATER', quantity=100, unit=ML}]}";
        // when
        drinkMaker.createCoffee(americano);

        //then
        Assertions.assertEquals(result, americano.toString());
    }


    @Test
    public void shouldMakeCoffeeWithLatteIngredient() {

        // given
        List<Ingredient> ingredients = Arrays.asList(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 37, Unit.ML),
                new Ingredient(IngredientName.MILK, 170, Unit.ML));

        Coffee latte = new Latte(ingredients);

        DrinkMaker drinkMaker = new DrinkMaker();

        String result = "Coffee{coffeeType=LATTE, ingredients=[Ingredient{name='beans', quantity=7, unit=GR}, " +
                "Ingredient{name='WATER', quantity=37, unit=ML}, " +
                "Ingredient{name='MILK', quantity=170, unit=ML}]}";

        // when
        drinkMaker.createCoffee(latte);

        //then
        Assertions.assertTrue(result.equalsIgnoreCase(latte.toString()));
    }
}
