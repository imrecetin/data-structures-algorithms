package com.problems.leetcode.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    //Horizontal scanning
    //O(S) , where S is the sum of all characters in all strings.
    //Space complexity : O(1)O(1). We only used constant extra space.
    public static String longestCommonPrefixV1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for(int i=1;i<strs.length;++i){
            while (strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
