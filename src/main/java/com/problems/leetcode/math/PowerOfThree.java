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

    //We will use the regular expression above for checking if the string starts with 1 ^1,
    // is followed by zero or more 0s 0* and contains nothing else ＄.
    /**
     * Time complexity : O(log_3n)
     * Space complexity : O(log_3n)
     * */
    public boolean isPowerOfThreeBaseConversion(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    public boolean isPowerOfThreeMathematics(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
