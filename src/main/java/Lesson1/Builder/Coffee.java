package Lesson1.Builder;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private CoffeeType coffeeType;
    private List<Addins> listAddins = new ArrayList<>();
    private Coffee(CoffeeBuilder coffeeBuilder){
        this.coffeeType = coffeeBuilder.coffeeType;
        this.listAddins = coffeeBuilder.listAddins;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public List<Addins> getListAddins() {
        return listAddins;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeType=" + coffeeType +
                ", listAddins=" + listAddins +
                '}';
    }

    public static class CoffeeBuilder{
        private CoffeeType coffeeType;
        private List<Addins> listAddins = new ArrayList<>();
        public CoffeeBuilder(){

        }
        public CoffeeBuilder withCoffeeType(CoffeeType coffeeType){
            this.coffeeType = coffeeType;
            return this;
        }
        public CoffeeBuilder withAddins(Addins addins){
            this.listAddins.add(addins);
            return this;
        }

        public Coffee createCoffee(){
            return new Coffee(this);
        }
    }
}
