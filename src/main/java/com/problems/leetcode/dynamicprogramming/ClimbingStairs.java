package com.problems.leetcode.dynamicprogramming;

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
}
