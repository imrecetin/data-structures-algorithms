package com.problems.leetcode;

import com.sun.crypto.provider.HmacPKCS12PBESHA1;

import java.util.*;

public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2};
        int[] intersect = intersectWithHashMap(nums1, nums2);
        Arrays.stream(intersect).forEach(System.out::println);
    }

    public static int[] intersectWithHashMap(int[] nums1, int[] nums2) {
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
                int minValue=Math.min(entry.getValue(),map2.getOrDefault(entry.getKey(),0));
                for (int i=0;i<minValue;++i)
                    result.add(entry.getKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersectWithTwoPointers(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        int i = 0;
        int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
