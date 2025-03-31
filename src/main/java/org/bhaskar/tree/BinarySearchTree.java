package org.bhaskar.tree;

public class BinarySearchTree {
    Node root;

    public boolean insert(int value){
        Node newNode=new Node(value);
        if(root==null) {
            root = newNode;
            return true;
        }
        Node temp=root;
        while(temp!=null){
            if(temp.value== newNode.value) return false;
            if(temp.value< newNode.value)
            {
                if(temp.right==null){
                    temp.right =newNode;
                    return true;
                }
                temp=temp.right;
            }else{
                if(temp.left==null){
                    temp.left =newNode;
                    return true;
                }
                temp=temp.left;
            }
        }
        return true;
    }

    public boolean contains(int value){
        Node temp = root;
        while(temp!=null){
            if(temp.value==value) return true;
            if(temp.value>value)
            {
                temp = temp.left;
            }else {
                temp = temp.right;
            }
        }
        return false;
    }


    public void printTree(){
        Node temp=root;
        while(temp!=null){

        }
    }

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value=value;
        }
    }
}
