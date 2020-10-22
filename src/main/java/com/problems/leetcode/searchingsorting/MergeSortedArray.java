package com.problems.leetcode.searchingsorting;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        while (m > 0 && n > 0){
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[index--] = nums1[--m];
            } else {
                nums1[index--] = nums2[--n];
            }
        }

        while (n > 0) {
            nums1[index--] = nums2[--n];
        }
        //System.arraycopy(nums2, 0, nums1, 0, n + 1);
    }
}
