package Lesson5.Additional;

import java.util.*;

public class MainCombination {
    static int uniqueClimbs (List<Integer> a, int numberOfSteps) {
        System.out.println(numberOfSteps);
        int i=0;
        if (numberOfSteps == 0) {
            return 1;
        }
        if (a.contains(numberOfSteps)) {
            return 1;
        }
        if (numberOfSteps < 0) {
            return 0;

        }
        for (Integer k : a) {
            i += uniqueClimbs(a, numberOfSteps - k);
        }
        return i;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(1);
        System.out.println(uniqueClimbs(a,5));
    }


}
