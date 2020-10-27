package com.problems.leetcode.easy.array;

import java.util.*;

public class CreateTargetArrayInTheGivenOrder {
    public static void main(String[] args) {
        final int[] nums = Arrays.asList(1, 2, 3, 4, 5).stream().mapToInt(Integer::intValue).toArray();
        final int[] index = Arrays.asList(0, 2, 1, 4, 3).stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(createTargetArray(nums,index)).forEach(
                System.out::println
        );
        System.out.println();
        Arrays.stream(createTargetArrayWithArrayList(nums,index)).forEach(
                System.out::println
        );
    }

    public static int[] createTargetArrayWithArrayList(int[] nums, int[] index) {
        List<Integer> lst = new ArrayList<>(Collections.nCopies(nums.length, 0));
        for (int i = 0; i < index.length; i++)
            lst.add(index[i], nums[i]);

        return lst.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target=new int[nums.length];
        Arrays.fill(target, -1);
        for(int i=0;i<nums.length;++i){
            if (target[index[i]]!=-1){
                shiftElements(target,index[i]);
            }
            target[index[i]]=nums[i];
        }
        return target;
    }

    private static void shiftElements(int[] input, int index) {
        for(int i = input.length-2; i >= index; i--) {
            input[i+1] = input[i];
        }
    }
}
