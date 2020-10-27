package com.problems.leetcode.easy.string;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-1234));
        System.out.println(reverse(1234));
    }

    public static int reverse(int x) {
        int rev=0;
        while(x!=0){
            int pop=x%10;
            x=x/10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev=rev*10+pop;
        }
        return rev;
    }

    public int reverseUsingTempLongType(int x) {
        long result =0;
        while(x != 0)
        {
            result = (result*10) + (x%10);
            if(result > Integer.MAX_VALUE) return 0;
            if(result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }
        return (int)result;
    }

    /*
        //pop operation:
        pop = x % 10;
        x /= 10;

        //push operation:
        temp = rev * 10 + pop;
        rev = temp;
     */
}
