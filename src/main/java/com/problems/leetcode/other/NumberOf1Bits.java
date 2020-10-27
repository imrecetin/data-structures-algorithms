package com.problems.leetcode.other;

public class NumberOf1Bits {

    // you need to treat n as an unsigned value
    /**
     * The run time depends on the number of bits in n.
     * Because nn in this piece of code is a 32-bit integer, the time complexity is O(1).
     * The space complexity is O(1), since no additional space is allocated.
     * */
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    public int hammingWeightBitManipulationTrick(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }


}
