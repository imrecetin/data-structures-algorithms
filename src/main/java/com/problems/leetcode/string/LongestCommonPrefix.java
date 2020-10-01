package com.problems.leetcode.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        longestCommonPrefixV2(new String[]{"leets","leetcode"});
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

    //Vertical scanning
    //Time complexity : O(S)O(S) , where S is the sum of all characters in all strings.
    //Space complexity : O(1)O(1). We only used constant extra space.
    public static String longestCommonPrefixV2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    //Divide And Conquer
    //Time complexity : O(S)O(S), where SS is the number of all characters in the array
    //Space complexity : O(m \cdot \log n)O(m⋅logn)
    public String longestCommonPrefixV3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}
