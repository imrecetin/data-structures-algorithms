package com.problems.leetcode.easy.dynamicprogramming;

public class ClimbingStairs {

    //Time complexity : O(2^n). Size of recursion tree will be 2^n
    public int climbStairsBruteForce(int n) {
        return climb_Stairs_BruteForce(0, n);
    }
    public int climb_Stairs_BruteForce(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs_BruteForce(i + 1, n) + climb_Stairs_BruteForce(i + 2, n);
    }

    //Time complexity : O(n). Size of recursion tree can go upto n.
    //Space complexity : O(n). The depth of recursion tree can go upto n.
    public int climbStairsRecursionWithMemorization(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs_RecursionWithMemorization(0, n, memo);
    }
    public int climb_Stairs_RecursionWithMemorization(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs_RecursionWithMemorization(i + 1, n, memo) + climb_Stairs_RecursionWithMemorization(i + 2, n, memo);
        return memo[i];
    }

    //Time complexity : O(n). Single loop upto n.
    //Space complexity : O(n). dpdp array of size nn is used.
    public int climbStairsDynmaicProgramming(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //Time complexity : O(n). Single loop upto n is required to calculate n^{th} fibonacci number.
    //Space complexity : O(1). Constant space is used.
    public int climbStairsSimilarFibonacciNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
