package com.problems.leetcode;

import java.util.Arrays;
import java.util.List;

public class RotateArray {

    public static void main(String[] args) {
        Integer nums[]={1, 2, 3, 4, 5, 6};
        rotate3(nums,2);
        Arrays.asList(nums).stream().map(String::valueOf).forEach(System.out::print);
        rotate3(nums,nums.length-4);
        System.out.println();
        Arrays.asList(nums).stream().forEach(System.out::print);
        rotate3(nums,nums.length-4);
        System.out.println();
        Arrays.asList(nums).stream().forEach(System.out::print);
    }

    //Brute Force
    public static void rotate(Integer[] nums, int k) {
        int temp, previous;
        for (int i=0;i<k;++i){
            previous=nums[nums.length-1];
            for (int j=0;j<nums.length;++j){
                temp=nums[j];
                nums[j]=previous;
                previous=temp;
            }
        }
    }

    //Using Extra Array
    public static void rotate2(Integer[] nums, int k) {
        Integer [] rotated=new Integer [nums.length];
        for (int i=0;i<nums.length;++i){
            rotated[(i+k)%nums.length]=nums[i];
        }
        for (int i=0;i<nums.length;++i){
            nums[i]=rotated[i];
        }
        nums = Arrays.copyOf(rotated, rotated.length);
    }

    //Using Reverse
    public static void rotate3(Integer[] nums, int k) {
            reverse(nums,0,nums.length-1);
            reverse(nums,0,k-1);
            reverse(nums,k,nums.length-1);
    }

    public static void reverse(Integer[] nums, int start, int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            ++start;
            --end;
        }
    }
}
