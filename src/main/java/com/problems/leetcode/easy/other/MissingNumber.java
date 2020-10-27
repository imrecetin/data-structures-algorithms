package com.problems.leetcode.easy.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    //If nums were in order, it would be easy to see which number is missing.
    /**
     * Time complexity  : O(nlgn)
     * Space complexity : O(1)
     * */
    public int missingNumberSorting(int[] nums) {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // Ensure that 0 is at the first index
        else if (nums[0] != 0) {
            return 0;
        }

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }

        // Array was not missing any numbers
        return -1;
    }

    /**
     * Time complexity  : O(n)
     * Space complexity : O(n)
     * */
    public int missingNumberHashSet(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    /**
     * missing
     * =4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
     * =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
     * =0∧0∧0∧0∧2
     * =2
     * */
    //if we initialize an integer to nn and XOR it with every index and value, we will be left with the missing number.
    /**
     * Time complexity  : O(n)
     * Space complexity : 1
     * */
    public int missingNumberBitManupulation(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * Time complexity  : O(n)
     * Space complexity : 1
     * */
    public int missingNumberGaussFormula(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
