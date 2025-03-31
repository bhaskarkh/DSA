package org.interview.jpmc;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MyImutable {
    public static void main(String[] args) {
        int[] intArray= {9,7,13,15,2};

        //o/p=> 2,15,13,7,9
        System.out.println(Arrays.toString(reverseArray(intArray)));

        int[] intArray2= {1,25,35,27,8,22};
        Arrays.stream(intArray2)
                .boxed()
                .map(num -> num+"")
                .filter(numStr->numStr.startsWith("2"))
                .toList().forEach(System.out::println);


    }

    private static int[] reverseArray(int[] intArray) {
        //{9,7,13,15,2};
        if(intArray.length ==0) return intArray;
        int start=0;
        int end= intArray.length-1;

        while(start<end){
            int temp=intArray[start];
            intArray[start]=intArray[end];
            intArray[end] = temp;
            start++;
            end--;
        }
        return  intArray;
    }

}
