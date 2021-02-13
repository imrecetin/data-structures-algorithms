package com.problems.leetcode.easy.other;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibWithRecursion(10)==fibWithIteration(10));
        Map<Integer,Integer> calculatedValue=new HashMap<>();
        calculatedValue.put(0,0);
        calculatedValue.put(1,1);
        System.out.println(fibWithRecursionWithDynamic(10,calculatedValue)==fibWithIteration(10));
    }

    public static int fibWithRecursion(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fibWithRecursion(n-1)+fibWithRecursion(n-2);
    }

    public static int fibWithRecursionWithDynamic(int n, Map<Integer,Integer> calculatedValue){
        if(calculatedValue.containsKey(n))
            return calculatedValue.get(n);
        calculatedValue.put(n,fibWithRecursionWithDynamic(n-1,calculatedValue)+fibWithRecursionWithDynamic(n-2,calculatedValue));
        return calculatedValue.get(n);
    }

    public static int fibWithIteration(int n){
        int number1=0;
        int number2=1;
        int sum=number1+number2;
        while(n>1){
            sum=number1+number2;
            number1=number2;
            number2=sum;
            n--;
        }
        return sum;
    }
}
