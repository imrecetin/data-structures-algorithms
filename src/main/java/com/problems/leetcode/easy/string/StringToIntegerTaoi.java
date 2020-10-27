package com.problems.leetcode.easy.string;

public class StringToIntegerTaoi {
    public static void main(String[] args) {
            System.out.println(myAtoi("  "));
    }

    public static int myAtoiWithSimpleFourStep(String str){
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
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
