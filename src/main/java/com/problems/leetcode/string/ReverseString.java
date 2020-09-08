package com.problems.leetcode.string;
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
}
