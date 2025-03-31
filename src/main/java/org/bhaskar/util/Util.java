package org.bhaskar.util;

public class Util {
    public static void print2dArray(int[][] img,String message) {
        System.out.println("------------- ");
        System.out.println(message);

        for(int i=0;i<img.length;i++)
        {
            for(int j=0;j<img[0].length;j++)
            {
                System.out.print(img[i][j]);
                if(j!=img[0].length-1)
                    System.out.print(" ,");
            }
            System.out.println("");
        }
    }
}
