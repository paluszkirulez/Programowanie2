package Lesson5.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    static public List<String> filterStrings(List<String> myList){
        return myList.stream().filter(x->x.length()==4 && x.charAt(0)=='s').collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("ala");
        a.add("pies");
        a.add("snake");
        a.add("sony");
        System.out.println(filterStrings(a));
    }

}
