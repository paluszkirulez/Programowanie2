package Lesson5.Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReversortStrings {
    static public List<String> reverseSort(List<String> a){
        return a.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("snake");
        a.add("ala");
        a.add("pies");
        a.add("snake");
        a.add("sony");
        System.out.println(reverseSort(a));
    }
}
