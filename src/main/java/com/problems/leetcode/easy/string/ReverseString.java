package com.problems.leetcode.easy.string;
import java.util.stream.Stream;

public class ReverseString {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        reverseString(chars);
        Stream.of(chars).forEach(System.out::println);
    }

    public static void reverseString(char[] s) {
        if (s==null || s.length==1)
            return ;
        for(int i=0;i<s.length/2;++i){
            char temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
    }

    public static void reverseStringWithStringBuilder(char[] s) {
        String text=new StringBuilder(String.valueOf(s)).reverse().toString();
        s=text.toCharArray();
    }

    //  Divide and Conquer (Recursive)
    //  O(n log(n))` (Average Case) and `O(n * log(n))` (Worst Case)
    public static String reverseString(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
}
