package Lesson5.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortByOne {
    static public List<String> sortByFirstLetter(List<String> b){
        return b.stream().sorted((o1, o2) -> Character.compare(o1.charAt(0),o2.charAt(0))).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("sony");
        a.add("ala");
        a.add("pies");

        a.add("sake");
        a.add("spot");
        System.out.println(sortByFirstLetter(a));
    }
}
