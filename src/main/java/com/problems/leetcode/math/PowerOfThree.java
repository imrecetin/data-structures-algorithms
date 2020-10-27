package com.problems.leetcode.math;

public class PowerOfThree {

    /**
     * Time complexity : O(log_b(n))
     * In our case that is O(log_3n)
     * Space complexity : O(1) We are not using any additional memory.
     * */
    public boolean isPowerOfThreeLoopIteration(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
