package com.problems.leetcode.easy.string;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aadadaad"));
        System.out.println(firstUniqCharWithHashMap("aadadaad"));
    }

    public static int firstUniqCharWithHashMap(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
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
