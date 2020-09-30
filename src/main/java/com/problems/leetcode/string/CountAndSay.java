package com.problems.leetcode.string;

public class CountAndSay {
    public static void main(String[] args) {

    }

    public static String countAndSay(int n) {
        if(n == 1) return "1";

        String prev = countAndSay(n-1);
        StringBuilder res = new StringBuilder();

        int i = 0;

        while(i < prev.length()) {
            char current = prev.charAt(i);

            int j = i+1;
            while(j< prev.length() && prev.charAt(j) == current) {
                j++;
            }
            res.append(j-i);
            res.append(current);
            i=j;
        }
        return res.toString();
    }

    public static String countAndSayWithHelper(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = helper(s);
        }
        return s;
    }

    private static String helper(String num) {
        String n = "";
        for (int i = 0; i < num.length(); ) {
            int j = 0;
            while (i + j < num.length() && num.charAt(i + j) == num.charAt(i)) j++;
            n += "" + j + num.charAt(i);
            i += j;
        }
        return n;
    }

}
