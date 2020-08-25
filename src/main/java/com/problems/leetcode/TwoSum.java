package com.problems.leetcode;

public class TwoSum {

    public static void main(String[] args) {
        int[] indices = twoSumBF(new int[]{2, 7, 11, 15}, 9);
        System.out.println(String.format("Indices %s %s", indices[0], indices[1]));
        indices = twoSumBF(new int[]{3, 3}, 6);
        System.out.println(String.format("Indices %s %s", indices[0], indices[1]));
        indices = twoSumBF(new int[]{3, 2, 4}, 6);
        System.out.println(String.format("Indices %s %s", indices[0], indices[1]));
    }

    public static int[] twoSumBF(int[] nums, int target) {
        int[] indices=new int[]{0,0};
        for (int i=0;i<nums.length-1;++i){
            int temp=nums[i];
            for (int j=i+1;j<nums.length;j++){
                if ((temp + nums[j])==target) {
                    indices[0]=i;
                    indices[1]=j;
                    return indices;
                }
            }
        }
        return indices;
    }

}
