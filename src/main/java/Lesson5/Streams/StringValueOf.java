package Lesson5.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringValueOf {
    public static String modify(int k) {
        return k % 2 == 0 ? "p"+k : "c"+k;
    }

    static public List<String> stringValueOf(Integer[] a){
        return Stream.of(a).map(k -> modify(k)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3};
        System.out.println(stringValueOf(a));
    }
}
