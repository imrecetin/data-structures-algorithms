package com.problems.leetcode;

import sun.lwawt.macosx.CSystemTray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Integer nums[]={1, 2, 3, 4, 5, 1};
        System.out.println(containsDuplicate(Arrays.asList(nums).stream().mapToInt(Integer::intValue).toArray()));
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums.length==0 || nums.length==1)
            return false;
        for (int i=0;i<nums.length-1;++i){
            for (int j=i+1;j<nums.length;++j){
                if (nums[i]==nums[j])
                    return true;
            }
        }
        return false;
    }

    //(Sorting)
    public static boolean  containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    //(HashTable)
    public static boolean  containsDuplicate3(int[] nums) {
        Set<Integer> container=new HashSet<>(nums.length);
        for (int num:nums){
            if (container.contains(num)) return true;
            container.add(num);
        }
        return false;
    }
}
