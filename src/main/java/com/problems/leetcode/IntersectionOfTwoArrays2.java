package com.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length==0)
            return new int[]{};
        if (nums2.length==0)
            return new int[]{};

        List<Integer> result=new ArrayList<Integer>();
        for (int i=0;i<nums1.length;++i){
            for (int j=0;j< nums1.length;++j){
                if (nums1[i]==nums2[j])
                    result.add(nums1[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
