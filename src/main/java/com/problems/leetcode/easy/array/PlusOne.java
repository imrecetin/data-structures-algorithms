package com.problems.leetcode.easy.array;

import java.util.Arrays;
import java.util.Stack;

public class PlusOne {
    public static void main(String[] args) {
        int[] result = plusOne(new int[]{8,9,9,9});
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] plusOne(int[] digits) {
        if (digits[digits.length-1]+1<10) {
            digits[digits.length-1]=digits[digits.length-1]+1;
            return digits;
        }
        Stack<Integer> stackTotalNumbers=new Stack<Integer>();
        int i=0;
        boolean holder=false;
        for (;i<digits.length;++i) {
            if ((digits[digits.length-1-i]+1)>=10){
                int remaining=(digits[digits.length-1-i]+1)%10;
                stackTotalNumbers.push(remaining);
                holder=true;
            }else{
                stackTotalNumbers.push(digits[digits.length-1-i]+1);
                holder=false;
                ++i;
                break;
            }
        }
        for (;i<digits.length;++i) {
            stackTotalNumbers.push(digits[digits.length-1-i]);
        }
        if (holder){
            stackTotalNumbers.add(1);
        }
        int[] results=new int[stackTotalNumbers.size()];
        for(i=0;stackTotalNumbers.size() > 0;++i){
            results[i]=stackTotalNumbers.pop();
        }
        return results;
    }

    public int[] plusOneSimpleSolution(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        return newNumber;
    }
}
