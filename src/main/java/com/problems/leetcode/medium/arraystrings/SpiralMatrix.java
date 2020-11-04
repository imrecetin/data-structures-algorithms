package com.problems.leetcode.medium.arraystrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    //Simulation
    /**
     * Time Complexity: O(N), where NN is the total number of elements in the input matrix. We add every element in the matrix to our final answer.
     * Space Complexity: O(N), the information stored in seen and in ans.
     * */
    public List<Integer> spiralOrderV1(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
}
