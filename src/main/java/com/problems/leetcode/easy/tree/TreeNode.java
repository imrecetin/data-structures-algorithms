package com.problems.leetcode.easy.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this(val);
        this.left=left;
        this.right=right;
    }

}
