package org.interview.jpmc;


import javax.swing.*;

public class Interview {
    public static void main(String[] args) {
        int ch=myAtoi("42");
        System.out.println(ch);
        //3 row 4 column
        //sorted order
        //target number 25
        //map(conpliment, number)
       /* 24,1 ;  23,2

        1  2  4  5
        7  8  10 11
        13 15 17 20

            0,0 0,1 0,4*/

               // left row =0, 0  (0,3)
                // right        row=n-1, m-1; (2,3) (2,0)

        //map
        //key = name
        //value = counter

       /* => csv 1 million
                => capacity
                => 50 * string
                => column 100
            = 100 * 50 * 1 * 1000000

            =50K



        file */





    }

    public static int myAtoi(String s) {
        char[] charArray=s.trim().toCharArray();
        int num=0;


        for(char c:charArray){
            if(Character.isDigit(c)){
                num=(num*10)+Character.getNumericValue(c);
            }else{
                return num;
            }
        }
        return num;
    }
}
