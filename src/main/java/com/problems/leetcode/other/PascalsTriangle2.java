package com.problems.leetcode.other;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

    //Dynamic Programming
    //Could you optimize your algorithm to use only O(k) extra space?
    public List<Integer> generate(int numRows) {
        List<Integer> row = new ArrayList<>();
        if (numRows < 0) {
            return row;
        }
        row.add(1);
        for (int i = 1; i <= numRows; i++) {
            for (int j = row.size() - 1; j > 0; j--) {
                row.set(j,row.get(j - 1) + row.get(j));
            }
            row.add(1);
        }
        return row;
    }
}
