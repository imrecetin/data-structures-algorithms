package com.problems.leetcode.easy.math;

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
public class RomanToInteger {

    public int romanToValue(char c){
        if(c=='I'){return 1 ; }
        if(c=='V'){return 5 ; }
        if(c=='X'){return 10 ; }
        if(c=='L'){return 50;}
        if(c=='C'){return 100 ;}
        if(c=='D'){return 500 ;}
        if(c=='M'){return 1000 ; }
        else{
            return 0 ;
        }
    }

    public int romanToInt(String s) {
        int result = 0;

        for(int i = 0 ;i<s.length()-1 ; i++){
            // System.out.println(s.charAt(i+1)) ;
            int curr = romanToValue(s.charAt(i)) ;
            int next = romanToValue(s.charAt(i+1)) ;
            if(next>curr){
                curr = -(curr) ;
            }
            result +=curr ;
        }

        //This is for the last charatcer of the string as lop only iterates for s.length()-2 times
        result +=romanToValue(s.charAt(s.length()-1)) ;
        return result ;
    }

}
