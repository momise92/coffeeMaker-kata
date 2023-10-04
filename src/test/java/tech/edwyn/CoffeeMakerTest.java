package tech.edwyn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.edwyn.models.*;


public class CoffeeMakerTest {

    @Test
    public void shouldMakeCoffeeWithEspressoIngredient() {

        // given
        CoffeeAbstractFactory  espressoFactory = new EspressoFactory(CoffeeType.ESPRESSO, 7, 37);
        String result = "Coffee{coffeeType=ESPRESSO, ingredients=[Ingredient{name='BEANS', quantity=7, unit=GR}, Ingredient{name='WATER', quantity=37, unit=ML}]}";
        DrinkMaker drinkMaker = new DrinkMaker();

        // when
        Coffee espresso = drinkMaker.makeCoffee(espressoFactory);

        //then
        Assertions.assertEquals(result, espresso.toString());
    }

    @Test
    public void shouldThrowExceptionWithCoffeeInvalidIngredient() {

        // given
        CoffeeAbstractFactory  espressoFactory = new EspressoFactory(CoffeeType.ESPRESSO, 100, 37);
        DrinkMaker drinkMaker = new DrinkMaker();

        // when
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> drinkMaker.makeCoffee(espressoFactory));

        //then
        Assertions.assertEquals("Ingredients is not valid", thrown.getMessage());
    }

    @Test
    public void shouldMakeCoffeeWithAmericanoIngredient() {

        // given
        CoffeeAbstractFactory  americanoFactory = new AmericanoFactory(CoffeeType.AMERICANO, 7, 100);
        String result = "Coffee{coffeeType=AMERICANO, ingredients=[Ingredient{name='BEANS', quantity=7, unit=GR}, Ingredient{name='WATER', quantity=100, unit=ML}]}";
        DrinkMaker drinkMaker = new DrinkMaker();

        // when
        Coffee americano = drinkMaker.makeCoffee(americanoFactory);

        //then
        Assertions.assertEquals(result, americano.toString());
    }


    @Test
    public void shouldMakeCoffeeWithLatteIngredient() {

        // given
        CoffeeAbstractFactory  latteFactory = new LatteFactory(CoffeeType.LATTE, 7, 37, 170);
        String result = "Coffee{coffeeType=LATTE, ingredients=[Ingredient{name='beans', quantity=7, unit=GR}, " +
                "Ingredient{name='WATER', quantity=37, unit=ML}, " +
                "Ingredient{name='MILK', quantity=170, unit=ML}]}";
        DrinkMaker drinkMaker = new DrinkMaker();
        // when
        Coffee latte = drinkMaker.makeCoffee(latteFactory);

        //then
        Assertions.assertTrue(result.equalsIgnoreCase(latte.toString()));
    }
}
