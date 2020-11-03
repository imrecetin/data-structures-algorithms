package com.problems.leetcode.medium.arraystrings;

import java.util.*;
import java.util.stream.Collectors;

public class Sum3 {

    public static void main(String[] args) {
        List<List<Integer>> results = threeSumBF(new int[]{-1, 2, 1, 2, -1, -4});
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

    public static List<List<Integer>> threeSumBF(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {                      //skip the same numbers
                continue;
            }
            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {    //skip the same numbers from  end of the array
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    j++;
                    k--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumWith2Sum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results=new ArrayList<List<Integer>>();
        for (int i=0;i<nums.length;i++){
            List<Integer> convertedNumList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            convertedNumList.remove(i);
            int[] tempArray=convertedNumList.stream().mapToInt(Integer::intValue).toArray();
            int[] indicesFor2Sum = twoSumTwoPassHashTable(tempArray, nums[i] * -1);

            if (indicesFor2Sum.length == 2 && indicesFor2Sum[0]!=-1 && indicesFor2Sum[1]!=-1) {
                results.add(Arrays.asList(nums[i],tempArray[indicesFor2Sum[0]],tempArray[indicesFor2Sum[1]]));
            }
        }
        return results;
    }

    public static int[] twoSumTwoPassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return new int[]{-1,-1};
        //throw new IllegalArgumentException("No two sum solution");
    }

}
