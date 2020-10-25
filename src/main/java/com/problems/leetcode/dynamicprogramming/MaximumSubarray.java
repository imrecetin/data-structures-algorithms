package com.problems.leetcode.dynamicprogramming;

import java.util.ArrayList;

public class MaximumSubarray {

    public int maxSubArrayBruteForce(int[] nums) {
        int max=nums[0];
        int sum=0;
        int y=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i;j<nums.length;j++)
            {
                list.add(nums[j]);

                sum=sum+list.get(y);
                max=Math.max(max,sum);
                y++;
            }
            list=new ArrayList<>();
            sum=0;
            y=0;
        }
        return max;
    }

    public int[] maxSubArrayDividAncConquer(int[] arr, int l, int r) {
        if (l == r) {
            return new int[] {arr[l], arr[l], arr[l], arr[l]};
        }

        int m = l + (r - l)/2;
        int[] res1 = maxSubArrayDividAncConquer(arr, l, m);
        int[] res2 = maxSubArrayDividAncConquer(arr, m+1, r);

        int leftBest = Math.max(res1[0], res1[3] + res2[0]);
        int rightBest = Math.max(res2[1], res2[3] + res1[1]);
        int middleBest = res1[1] + res2[0];

        int allBest = Math.max(res1[2], res2[2]);
        int allSum = res1[3] + res2[3];

        allBest = Math.max(allBest, leftBest);
        allBest = Math.max(allBest, rightBest);
        allBest = Math.max(allBest, middleBest);
        //allBest = Math.max(allBest, allSum);//no need, if allSum will win, leftBest/rightBest/middleBest already won
        return new int[]{leftBest, rightBest, allBest, allSum};
    }

    public int maxSubArray(int[] nums){
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length ; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }

    public int maxSubArrayDynamicProgramming(int[] a) {
        int l_max = a[0];
        int g_max = a[0];
        for (int i = 1; i < a.length; i++){
            l_max = Math.max (a[i], a[i]+l_max);
            g_max = Math.max(g_max, l_max);
        }
        return g_max;
    }

}
