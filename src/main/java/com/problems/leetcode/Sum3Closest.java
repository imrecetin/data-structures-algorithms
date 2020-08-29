package com.problems.leetcode;
import java.util.Arrays;

public class Sum3Closest {
    public static void main(String[] args) {
        int results = threeSumClosest(new int[]{-3,0,1,2},1);
        System.out.println(results);
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length==3){
           return Arrays.stream(nums).sum();
        }
        Arrays.sort(nums);
        int total3Sum=0;
        int complement=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;++i){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int tempComplement=Math.abs((target-(nums[i]+nums[k]+nums[j])));
                if(complement>tempComplement){
                    total3Sum=nums[i]+nums[k]+nums[j];
                    complement=tempComplement;
                }
                ++j;
                --k;
            }
        }
        return total3Sum;
    }

}