package com.problems.leetcode.searchingsorting;

public class FirstBadVersion {

    //The straight forward way is to brute force it by doing a linear scan.
    //Time Limit Exceeded
    public int firstBadVersionWithLinearScan(int n) {
        for (int i = 1; i < n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }

    //Time complexity : O(logn). The search space is halved each time, so the time complexity is O(logn).
    //Space complexity : O(1).
    public int firstBadVersionWithBinarySearch(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    boolean isBadVersion(int version){
        return true;
    }
}
