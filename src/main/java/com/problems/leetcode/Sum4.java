package com.problems.leetcode;

import java.util.List;

public class Sum4 {
    public static void main(String[] args) {
        List<List<Integer>> results = fourSum(new int[]{1, 0, -1, 0, -2, 2},0);
        for (List<Integer> result:results) {
            final StringBuilder sb=new StringBuilder();
            sb.append(" [ ");
            result.stream().forEach(num->{
                sb.append(" "+num+" ");
            });
            sb.append(" ] ");
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

    }
}
