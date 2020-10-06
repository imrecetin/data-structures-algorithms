package com.problems.leetcode.tree;

import com.sun.scenario.effect.Brightpass;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode rihtgNode=new TreeNode(1);
        TreeNode root=new TreeNode(1,null,rihtgNode);
        isValidBST(root,null,null);
    }

    //Time complexity : O(N) since we visit each node exactly once.
    //Space complexity : O(N) since we keep up to the entire tree.
    public static boolean isValidBST(TreeNode root,Integer lowerLimit,Integer upperLimit) {
        if (root==null)
            return true;
        if (lowerLimit != null && root.val <= lowerLimit) return false;
        if (upperLimit != null && root.val >= upperLimit) return false;
        if (! isValidBST(root.right, root.val, upperLimit)) return false;
        if (! isValidBST(root.left, lowerLimit, root.val)) return false;
        return true;
    }

    public static boolean isValidBSTWithIteration(TreeNode root,Integer lowerLimit,Integer upperLimit) {
        if (root==null)
            return true;
        return true;
    }
}
