package tech.edwyn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.edwyn.models.*;
import tech.edwyn.models.enums.CoffeeType;
import tech.edwyn.models.enums.IngredientName;
import tech.edwyn.models.enums.Unit;
import tech.edwyn.strategy.AmericanoStrategy;
import tech.edwyn.strategy.EspressoStrategy;
import tech.edwyn.strategy.LatteStrategy;
import tech.edwyn.strategy.MakeCoffeeStrategy;

import java.util.List;


public class CoffeeMakerTest {

    @Test
    public void shouldMakeCoffeeWithEspressoIngredient() {

        // given
        MakeCoffeeStrategy espressoStrategy = new EspressoStrategy();

        List<Ingredient> ingredients = List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 37, Unit.ML));

        DrinkMaker drinkMaker = new DrinkMaker(CoffeeType.ESPRESSO, ingredients);

        String result = "Coffee{coffeeType=ESPRESSO, ingredients=[Ingredient{name='BEANS', quantity=7, unit=GR}, Ingredient{name='WATER', quantity=37, unit=ML}]}";
        // when
        Coffee espresso = drinkMaker.makeCoffee(espressoStrategy);
        //then
        Assertions.assertEquals(result, espresso.toString());
    }

    @Test
    public void shouldThrowExceptionWithCoffeeInvalidIngredient() {

        // given
        MakeCoffeeStrategy espressoStrategy = new EspressoStrategy();

        List<Ingredient> ingredients = List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 100, Unit.ML));

        DrinkMaker drinkMaker = new DrinkMaker(CoffeeType.ESPRESSO, ingredients);

        // when
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> drinkMaker.makeCoffee(espressoStrategy));

        //then
        Assertions.assertEquals("Ingredients is not valid", thrown.getMessage());
    }

    @Test
    public void shouldMakeCoffeeWithAmericanoIngredient() {

        // given
        MakeCoffeeStrategy americanoStrategy = new AmericanoStrategy();

        List<Ingredient> ingredients = List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 100, Unit.ML));

        DrinkMaker drinkMaker = new DrinkMaker(CoffeeType.AMERICANO, ingredients);

        String result = "Coffee{coffeeType=AMERICANO, ingredients=[Ingredient{name='BEANS', quantity=7, unit=GR}, Ingredient{name='WATER', quantity=100, unit=ML}]}";
        // when

        Coffee americano = drinkMaker.makeCoffee(americanoStrategy);

        //then
        Assertions.assertEquals(result, americano.toString());
    }


    @Test
    public void shouldMakeCoffeeWithLatteIngredient() {

        // given
        MakeCoffeeStrategy latteStrategy = new LatteStrategy();
        String result = "Coffee{coffeeType=LATTE, ingredients=[Ingredient{name='beans', quantity=7, unit=GR}, " +
                "Ingredient{name='WATER', quantity=37, unit=ML}, " +
                "Ingredient{name='MILK', quantity=170, unit=ML}]}";

        List<Ingredient> ingredients = List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 37, Unit.ML),
                new Ingredient(IngredientName.MILK, 170, Unit.ML));

        DrinkMaker drinkMaker = new DrinkMaker(CoffeeType.LATTE, ingredients);

        // when
        Coffee latte = drinkMaker.makeCoffee(latteStrategy);

        //then
        Assertions.assertTrue(result.equalsIgnoreCase(latte.toString()));
    }
}
