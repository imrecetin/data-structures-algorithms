package com.problems.leetcode.string;

public class ImplementstrStr {

    //What should we return when needle is an empty string? This is a great question to ask during an interview.
    public static void main(String[] args) {

    }

    public int strStrWithShortVersion(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public int strStr(String haystack, String needle) {
        if (needle==null || needle=="" ||needle.length()==0)
            return 0;
        if (needle.length()>haystack.length())
            return -1;
        for (int i=0;i<haystack.length();i++){
            int j=0;
            if (haystack.charAt(i)==needle.charAt(j) && (haystack.length()-i)>=needle.length()){
                for (j=1;j<needle.length() && haystack.charAt(i+j)==needle.charAt(j);++j){ }
                if (j==needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }
}
