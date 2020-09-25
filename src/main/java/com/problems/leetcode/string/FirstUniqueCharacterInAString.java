package com.problems.leetcode.string;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aadadaad"));
    }

    public static int firstUniqChar(String s) {
        if (s.length()==0)
            return -1;
        if (s.length()==1)
            return 0;

        int i=0;
        for (char charValue:s.toCharArray()) {
            if (checkUniqueness(charValue,s.substring(0, i) + s.substring(i + 1))){
                return i;
            }
            ++i;
        }
        return -1;
    }

    private static boolean checkUniqueness(char charValue, String substring) {
        if (substring.trim().length()==0){
            return false;
        }
        int counter=0;
        for (int i=0;i<substring.length() ;++i){
            if (substring.charAt(i)==charValue)
                ++counter;
            if (counter>0)
                return false;
        }
        return true;
    }
}
