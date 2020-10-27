package com.problems.leetcode.other;

public class ReverseBits {

    public int reverseBitsBitByBit(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans = ans | (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
