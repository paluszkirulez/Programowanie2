package Lesson1.Builder;

public class CoffeMain {
    public static void main(String[] args) {
        Coffee myCoffee = new Coffee.CoffeeBuilder()
                .withCoffeeType(CoffeeType.ESPRESSO)
                .withAddins(Addins.BROWN_SUGAR)
                .withAddins(Addins.WHIPECREAM)
                .createCoffee();
        System.out.println(myCoffee);

        System.out.println(new Coffee.CoffeeBuilder().withCoffeeType(CoffeeType.ESPRESSO));
    }
}
