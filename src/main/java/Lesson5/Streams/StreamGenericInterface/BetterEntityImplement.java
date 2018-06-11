package Lesson5.Streams.StreamGenericInterface;

public class BetterEntityImplement {
    public static <E> E betterEntityImplement(E e1, E e2, BetterEntity<E> k){
        return k.betterEntity(e1,e2) ? e1 : e2;
    }

    public static void main(String[] args) {
        Car car1 = new Car(500);
        Car car2 = new Car(700);

        System.out.println(betterEntityImplement("asd","dsa",(e,o)->e.length()>o.length()));
        System.out.println(betterEntityImplement(car1,car2,(e,o)->e.getPrice()>o.getPrice()));

    }

}
