package com.problems.leetcode.easy.other;

//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }

    /**
     *
     * Explanation:
     * consider :
     *  0^0=0; 1^1=0
     *  0^1=1; 1^0=1
     * i.e. only we will get set bit in XOR if either bit in numbers is 1 and other is 0
     * i.e if we XOR given two numbers let say 'ans' then set bit in ans will be our answer
     * as we required different bits in two numbers
     * Then calculate set bit in 'ans' using brian kernigham's algorithm to find set bit
     *
     * */
    public int hammingDistanceV2(int x, int y) {
        int num=x^y;
        int ans=0;
        while(num!=0){
            ans++;
            num=num & (num-1);
        }
        return ans;
    }
}
