package com.problems.leetcode;

import java.util.*;

public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] intersect = intersect(nums1, nums2);
        Arrays.stream(intersect).forEach(System.out::println);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length==0)
            return new int[]{};
        if (nums2.length==0)
            return new int[]{};
        HashMap<Integer,Integer> map1=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map2=new HashMap<Integer,Integer>();
        List<Integer> result=new ArrayList<Integer>();
        for (int i=0;i<nums1.length;++i){
           map1.put(nums1[i],map1.getOrDefault(nums1[i],0)+1);
        }
        for (int i=0;i<nums2.length;++i){
            map2.put(nums2[i],map2.getOrDefault(nums2[i],0)+1);
        }
        for (Map.Entry<Integer,Integer> entry:map1.entrySet()){
            if (map2.getOrDefault(entry.getKey(),0)!=0){
                for (int i=0;i<entry.getValue();++i)
                    result.add(entry.getKey());
                map2.put(entry.getKey(),map2.getOrDefault(entry.getKey(),0)-1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
