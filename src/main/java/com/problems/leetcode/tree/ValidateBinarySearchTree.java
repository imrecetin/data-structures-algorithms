package com.problems.leetcode.tree;

import com.sun.scenario.effect.Brightpass;

import java.util.LinkedList;

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

    static LinkedList<TreeNode> stack = new LinkedList();
    static LinkedList<Integer> uppers = new LinkedList(), lowers = new LinkedList();

    public static void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    //The above recursion could be converted into iteration, with the help of stack.
    // DFS would be better than BFS since it works faster here.
    public static boolean isValidBSTWithIteration(TreeNode root,Integer lowerLimit,Integer upperLimit) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null) continue;
            val = root.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }

}
