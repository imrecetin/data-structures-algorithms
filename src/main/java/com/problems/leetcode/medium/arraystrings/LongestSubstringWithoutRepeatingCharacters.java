package com.problems.leetcode.medium.arraystrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    //Brute Force
    /**
     * Time complexity : O(n^3)
     * Space complexity : O(min(n, m)). We need O(k) space for checking a substring has no duplicate characters,
     * where k is the size of the Set
     * */
    public int lengthOfLongestSubstringV1(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j))
                    ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

    //Sliding Window
    /**
     * Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by ii and jj.
     * Space complexity : O(min(m,n)). Same as the previous approach.
     * We need O(k) space for the sliding window, where k is the size of the Set.
     * */
    public int lengthOfLongestSubstringV2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //Sliding Window Optimized
    /**
     * Time complexity : O(n). Index jj will iterate nn times.
     * Space complexity (HashMap) : O(min(m, n)). Same as the previous approach.
     * Space complexity (Table): O(m). mm is the size of the charset.
     * */
    public int lengthOfLongestSubstringV3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
