package com.problems.leetcode.dynamicprogramming;

public class ClimbingStairs {

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

    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if (n==2)
            return 2;
        if(n==3)
            return 3;
        return climbStairs(n-1)+climbStairs(n-2);
    }
}
