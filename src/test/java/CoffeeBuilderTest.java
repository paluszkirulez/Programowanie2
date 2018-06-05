import Lesson1.Builder.Addins;
import Lesson1.Builder.Coffee;
import Lesson1.Builder.CoffeeType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoffeeBuilderTest {

    private Coffee coffee;

    @Before
    public void setup(){coffee = new Coffee.CoffeeBuilder()
            .withCoffeeType(CoffeeType.ESPRESSO)
            .withAddins(Addins.BROWN_SUGAR)
            .withAddins(Addins.WHIPECREAM)
            .createCoffee();}

    @Test
    public void coffeeSimpleTest(){
        Assert.assertEquals(CoffeeType.ESPRESSO,coffee.getCoffeeType());
    }
    @Test
    public void coffeeSimpleTest2(){
        List<Addins> myTestList = new ArrayList<>();
        myTestList.add(Addins.BROWN_SUGAR);
        myTestList.add(Addins.WHIPECREAM);
        Assert.assertEquals(myTestList,coffee.getListAddins());
    }
}
