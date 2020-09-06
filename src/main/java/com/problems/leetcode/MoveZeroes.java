package com.problems.leetcode;

public class MoveZeroes {
    public static void main(String[] args) {

    }

    public static void moveZeroes(int[] nums) {
        for (int i=0;i<nums.length;++i){
            if (nums[i]==0){
                for (int j=i;j<nums.length;++j){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
        }
    }
}
