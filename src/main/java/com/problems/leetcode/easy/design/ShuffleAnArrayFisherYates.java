package com.problems.leetcode.easy.design;

import java.util.Random;

/**
 * Time complexity : O(n)
 * The Fisher-Yates algorithm runs in linear time, as generating a random index and swapping two values can be done in constant time.
 * Space complexity : O(n)
 * Although we managed to avoid using linear space on the auxiliary array from the brute force approach,
 * we still need it for reset, so we're stuck with linear space complexity.
 * */
public class ShuffleAnArrayFisherYates {

    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleAnArrayFisherYates(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
}
