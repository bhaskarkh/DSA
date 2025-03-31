package org.bhaskar.tree;

public class BinarySearchTreeRunner {
    public static void main(String[] args) {
        BinarySearchTree myBinarySearch=new BinarySearchTree();
        myBinarySearch.insert(10);
        myBinarySearch.insert(15);
        myBinarySearch.insert(3);
        myBinarySearch.insert(4);
        myBinarySearch.insert(6);
        myBinarySearch.insert(6);
        System.out.println(myBinarySearch.root.left.right.value);
        System.out.println(myBinarySearch.contains(5));
    }
}
