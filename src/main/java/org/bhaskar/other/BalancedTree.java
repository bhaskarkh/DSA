package org.bhaskar.other;


import java.util.HashSet;
import java.util.Set;

public class BalancedTree {
    public static void main(String[] args) {

    }

     //Definition for a binary tree node.
     class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    public boolean isBalanced(TreeNode root) {
        Set<Integer> set=new HashSet<>();
        return heightOfTree(root)<2;

    }
    public int heightOfTree(TreeNode root)
    {
        if(root==null) return -1;
        int height=1+Math.abs(heightOfTree(root.left)-heightOfTree(root.right));
        return height;
    }
}
