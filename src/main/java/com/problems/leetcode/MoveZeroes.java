package com.problems.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] result = moveZeroes(new int[]{0,1,0,3,12});
        String text=Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(text);
    }

    public static int[] moveZeroes(int[] nums) {
        Queue<Integer> numsQueue=new LinkedList<Integer>();
        int counterForZeros=0;
        for (int i=0;i<nums.length;++i){
            if (nums[i]!=0){
                numsQueue.add(nums[i]);
            }else
                ++counterForZeros;
        }
        for (int i=0;i<counterForZeros;++i){
            numsQueue.add(0);
        }
        for (int i=0;numsQueue.size()!=0;++i){
            nums[i]=numsQueue.poll();
        }
        return nums;
    }

    public void moveZeroesWithTwoPointers2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0)
                nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public void moveZeroesWithTwoPointers(int[] nums) {
        int pos = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] != 0) {
                if(i != pos) {
                    nums[pos] = nums[i];
                    nums[i] = 0;
                }
                pos++;
            }
        }
    }

}
