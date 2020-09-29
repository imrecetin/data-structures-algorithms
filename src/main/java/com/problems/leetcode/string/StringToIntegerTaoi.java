package com.problems.leetcode.string;

public class StringToIntegerTaoi {
    public static void main(String[] args) {
            System.out.println(myAtoi("  "));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        String sign="";
        if (str==null || "".equals(str)){
            return 0;
        }
        if (str.charAt(0) == '-' || str.charAt(0) == '+'){
            sign=String.valueOf(str.charAt(0));
            str=str.substring(1);
        }else if (Character.isLetter(str.charAt(0))){
            return 0;
        }
        long sum=0;
        for (char c:str.toCharArray()) {
            if (Character.isDigit(c)){
                sum=sum*10+Long.valueOf(String.valueOf(c));
                if (sum>Integer.MAX_VALUE && "-".equals(sign)){
                    return -1*Integer.MAX_VALUE-1;
                }else if(sum>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }else
                break;
        }
        if ("-".equals(sign)){
            return -1*Long.valueOf(sum).intValue();
        }else{
            return Long.valueOf(sum).intValue();
        }
    }
}
