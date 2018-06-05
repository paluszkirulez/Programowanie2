package Lesson1.SecondSmallest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSecondSmallest {

    public int checkElement(int[] testArray){
       int[] myInts = new int[2];
        if(testArray.length == 0){
            return Integer.MIN_VALUE;
        }
        if (testArray.length==1){
            return testArray[0];
        }
       Arrays.sort(testArray);
        int k = testArray[0];
        for(int i= 0;i<testArray.length;i++){
            if(testArray[i]!=k ){
                return testArray[i];
            }
        }
        return testArray[k];

    }
}
