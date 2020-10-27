package com.problems.leetcode.easy.dynamicprogramming;

public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][1] = dp[i - 1][0] + nums[i];
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    // Space Optimization: Constant space or O(1) space
    public int robWithSpaceOptimization(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        //int[][] dp = new int[n][2];

        //dp[0][0] = 0;
        int previousItemExcluded = 0; // base case
        //dp[0][1] = nums[0];
        int previousItemIncluded = nums[0]; // base case

        int currentItemIncluded = 0;
        int currentItemExcluded = 0;

        for (int i = 1; i < n; i++) {
            currentItemIncluded = previousItemExcluded + nums[i];
            currentItemExcluded = Math.max(previousItemIncluded, previousItemExcluded);

            previousItemExcluded = currentItemExcluded;
            previousItemIncluded = currentItemIncluded;
        }
        return Math.max(previousItemExcluded, previousItemIncluded);
    }
}
