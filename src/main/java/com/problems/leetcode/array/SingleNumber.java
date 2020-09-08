package com.problems.leetcode.array;

import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {
        Integer nums[]={4,1,2,1,2};
        System.out.println(singleNumber(Arrays.asList(nums).stream().mapToInt(Integer::intValue).toArray()));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-1;i=i+2){
            if(i+1==nums.length) return nums[i];
            if(nums[i]!=nums[i+1]) return nums[i];

        }
        return 0;
    }

    //List operation
    public int singleNumber1(int[] nums) {
        List<Integer> no_duplicate_list = new ArrayList<>();

        for (int i : nums) {
            if (!no_duplicate_list.contains(i)) {
                no_duplicate_list.add(i);
            } else {
                no_duplicate_list.remove(new Integer(i));
            }
        }
        return no_duplicate_list.get(0);
    }

    //Hash Table
    public int singleNumber3(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }

    //Math
    public int singleNumber4(int[] nums) {
        int sumOfSet = 0, sumOfNums = 0;
        Set<Integer> set = new HashSet();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
        return 2 * sumOfSet - sumOfNums;
    }

    /**
     * Concept
     *
     * If we take XOR of zero and some bit, it will return that bit
     * a \oplus 0 = aa⊕0=a
     * If we take XOR of two same bits, it will return 0
     * a \oplus a = 0a⊕a=0
     * a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     * So we can XOR all bits together to find the unique number.
     *
     * */
    //Bit Manipulation
    public int singleNumber5(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
