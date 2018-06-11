package Lesson5.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BigStrings {
    static public List<String> convertLetters(List<String> s){

        return s.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("ala");
        a.add("pies");

        System.out.println(convertLetters(a));
    }


}
