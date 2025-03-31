package org.bhaskar.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class FloodFill {
    public static void main(String[] args) {

        int[][] img={{1,1,1},{1,1,0},{1,0,1}};
        int sr=1;
        int sc=1;
        int color=2;
        floodFill(img,sr,sc,color);
    }
    static class  Coordinate{
        int row;
        int col;
        Coordinate(int row,int col)
        {
            this.row=row;
            this.col=col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row && col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Stack<Coordinate> rr=new Stack();
        int[][] ss= floodFillRec(image,sr,sc,color,rr);
        return ss;
    }
    public static int[][] floodFillRec(int[][] image, int sr, int sc, int color, Stack<Coordinate> rr) {

        List<Coordinate> cList=findAllCordinate(image,sr,sc);
        for(Coordinate cor:cList)
        {
            if(image[cor.getRow()][cor.getCol()]==color) {
                rr.push(cor);
                image[cor.getRow()][cor.getCol()]=image[cor.getRow()][cor.getCol()]+1;
            }
        }
        if(rr.isEmpty()) return image;
        Coordinate corr=rr.pop();
        return floodFillRec(image,corr.getRow(),corr.getCol(),color,rr);
    }

    private static List<Coordinate> findAllCordinate(int[][] image,int sr, int sc) {
        List<Coordinate> cList=new ArrayList<>();
        if(sr!=0)cList.add(new Coordinate(sr-1,sc));
        if(sc!=0)cList.add(new Coordinate(sr,sc-1));
        if(sc<image[0].length)cList.add(new Coordinate(sr,sc+1));
        if(sr<image.length)cList.add(new Coordinate(sr+1,sc));
        return cList;
    }
}
