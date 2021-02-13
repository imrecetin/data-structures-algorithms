package com.problems.leetcode.easy.other;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibWithRecursion(10)==fibWithIteration(10));
    }

    public static int fibWithRecursion(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fibWithRecursion(n-1)+fibWithRecursion(n-2);
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
