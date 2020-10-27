package com.problems.leetcode.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Time complexity : {O}(n^2)
 * The quadratic time complexity arises from the calls to list.remove (or list.pop),
 * which run in linear time. nn linear list removals occur, which results in a fairly easy quadratic analysis.
 * Space complexity : {O}(n)
 * Because the problem also asks us to implement reset, we must use linear additional space to store the original array.
 * Otherwise, it would be lost upon the first call to shuffle.
 */
public class ShuffleAnArrayBruteForce {

    private int[] array;
    private int[] original;

    private Random rand = new Random();

    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    public ShuffleAnArrayBruteForce(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();

        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
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
