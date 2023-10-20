package tech.edwyn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.edwyn.models.*;

import java.util.List;


public class CoffeeMakerTest {

    @Test
    public void shouldMakeCoffeeWithEspressoIngredient() {

        // given
        MakeCoffeeStrategy coffeeStrategy = new EspressoMakeStrategy();
        List<Ingredient> ingredients = List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 37, Unit.ML));

        DrinkMaker drinkMaker = new DrinkMaker(CoffeeType.ESPRESSO, ingredients);
        String result = "Coffee{coffeeType=ESPRESSO, ingredients=[Ingredient{name='BEANS', quantity=7, unit=GR}, Ingredient{name='WATER', quantity=37, unit=ML}]}";
        // when
        Coffee espresso = drinkMaker.makeCoffee(coffeeStrategy);
        //then
        Assertions.assertEquals(result, espresso.toString());
    }

/*
    @Test
    public void shouldThrowExceptionWithCoffeeInvalidIngredient() {

        // given
        CoffeeStrategy espressoFactory = new EspressoFactory(CoffeeType.ESPRESSO, 100, 37);
        DrinkMaker drinkMaker = new DrinkMaker(coffee);
        // when
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> drinkMaker.makeCoffee(espressoFactory));

        //then
        Assertions.assertEquals("Ingredients is not valid", thrown.getMessage());
    }
*/

/*    @Test
    public void shouldMakeCoffeeWithAmericanoIngredient() {

        // given
        Coffee coffee = new Americano();

        List<Ingredient> ingredients = List.of(new Ingredient(IngredientName.BEANS, 7, Unit.GR),
                new Ingredient(IngredientName.WATER, 100, Unit.ML));

        String result = "Coffee{coffeeType=AMERICANO, ingredients=[Ingredient{name='BEANS', quantity=7, unit=GR}, Ingredient{name='WATER', quantity=100, unit=ML}]}";
        //DrinkMaker drinkMaker = new DrinkMaker(americano);
        // when


        //then
        Assertions.assertEquals(result, coffee.toString());
    }*/


/*    @Test
    public void shouldMakeCoffeeWithLatteIngredient() {

        // given
        CoffeeStrategy latteFactory = new LatteFactory(CoffeeType.LATTE, 7, 37, 170);
        String result = "Coffee{coffeeType=LATTE, ingredients=[Ingredient{name='beans', quantity=7, unit=GR}, " +
                "Ingredient{name='WATER', quantity=37, unit=ML}, " +
                "Ingredient{name='MILK', quantity=170, unit=ML}]}";
        DrinkMaker drinkMaker = new DrinkMaker(coffee);
        // when
        Coffee latte = drinkMaker.makeCoffee(latteFactory);

        //then
        Assertions.assertTrue(result.equalsIgnoreCase(latte.toString()));
    }*/
}
