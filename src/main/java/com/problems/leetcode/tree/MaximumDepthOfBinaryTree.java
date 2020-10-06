package com.problems.leetcode.tree;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static int maxDepthV2(TreeNode root) {
        if(root==null) return 0;
        int lh = maxDepth(root.left); //LST height
        int rh = maxDepth(root.right);//RST height
        return Math.max(lh,rh)+1;
    }

}
