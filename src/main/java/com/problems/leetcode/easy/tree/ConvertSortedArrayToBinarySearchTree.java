package com.problems.leetcode.easy.tree;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;

        return buildBST(nums, 0, nums.length-1);
    }

    static TreeNode buildBST(int[] nums, int startIndex, int endIndex){
        if(startIndex > endIndex) return null;
        int middleIndex = startIndex + (endIndex - startIndex)/2;
        TreeNode node = new TreeNode(nums[middleIndex]);
        node.left = buildBST(nums, startIndex, middleIndex-1);
        node.right = buildBST(nums, middleIndex+1, endIndex);
        return node;
    }
}
