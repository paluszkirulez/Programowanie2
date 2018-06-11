package Lesson5.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortEout {
    static public int compareStrings(String a, String b){
        if(a.charAt(0)=='e') return -1;
        else return 1;
    }
    static public List<String> sortByE(List<String> b){
        return b.stream().sorted((o1, o2) -> compareStrings(o1,o2)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("sony");
        a.add("ala");
        a.add("pies");
        a.add("encapsulation");
        a.add("sake");
        a.add("spot");
        a.add("emulator");
        a.add("encapsulation");
        a.add("spot");
        System.out.println(sortByE(a));
    }
}
