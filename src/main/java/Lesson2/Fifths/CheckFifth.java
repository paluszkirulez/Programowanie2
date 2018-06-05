package Lesson2.Fifths;

import java.util.ArrayList;
import java.util.List;

public class CheckFifth {
    public List<Integer> countFifths(int number) {
        List<Integer> myList = new ArrayList<>();
        for(int i = 0; i<=number;i++){
            String word = Integer.toString(i);
            for(int k = 0;k<word.length();k++){
                if(word.charAt(k) == '5'){
                    myList.add(i);
                    break;
                }
            }

        }


        return myList;
    }
}
