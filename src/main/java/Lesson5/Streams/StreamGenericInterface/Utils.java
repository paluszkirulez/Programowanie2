package Lesson5.Streams.StreamGenericInterface;

public class Utils {
    public static <E> E betterEntityImplement(E e1, E e2, BetterEntity k){
        return k.betterEntity(e1,e2) ? e1 : e2;
    }
}
