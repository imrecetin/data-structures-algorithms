package com.problems.leetcode.array;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(0, 1, 1, 2, 3, 3, 3, 4, 4, 5, 5, 5, 5);
        int len = removeDuplicates(nums.stream().mapToInt(Integer::intValue).toArray());
        System.out.println();
        System.out.println(len);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
        return i + 1;
    }
}
