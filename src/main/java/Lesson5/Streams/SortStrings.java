package Lesson5.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortStrings {
    static List<String> streamSort(List<String> a){
        return a.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("snake");
        a.add("ala");
        a.add("pies");
        a.add("snake");
        a.add("sony");
        System.out.println(streamSort(a));
    }
}
