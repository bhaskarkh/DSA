package org.bhaskar.other;

import org.bhaskar.util.Util;


public class FloodFill {
    public static void main(String[] args) {
        int[][] img={{1,1,1},{1,1,0},{1,0,1}};
        Util.print2dArray(img,"given Array");
        int sr=1;
        int sc=1;
        int color=2;
        floodFill(img,sr,sc,color);
        Util.print2dArray(img, "modified Array");
    }



    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int intialVal=image[sr][sc];
        floodFillRc(image,sr,sc,color,intialVal);
        return image;
    }

    public static void floodFillRc(int[][] image, int sr, int sc, int color,int initialVal){
        if(sr<0 || sc<0|| sr>=image.length || sc>=image[0].length || image[sr][sc]!=initialVal) return;
        image[sr][sc]=color;
        floodFillRc(image,sr+1,sc,color,initialVal);
        floodFillRc(image,sr,sc+1,color,initialVal);
        floodFillRc(image,sr-1,sc,color,initialVal);
        floodFillRc(image,sr,sc-1,color,initialVal);
    }
}
