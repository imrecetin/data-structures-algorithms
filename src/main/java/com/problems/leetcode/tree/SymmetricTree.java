package com.problems.leetcode.tree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {

    }

    //Time complexity : O(n). Because we traverse the entire input tree once, the total run time is O(n),
    //  where n is the total number of nodes in the tree.
    //Space complexity : The number of recursive calls is bound by the height of the tree.
    //  In the worst case, the tree is linear and the height is in O(n).
    //      Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case.
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)  && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    public static boolean isSymmetricWithIterative(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);

        }
        return true;
    }

}
