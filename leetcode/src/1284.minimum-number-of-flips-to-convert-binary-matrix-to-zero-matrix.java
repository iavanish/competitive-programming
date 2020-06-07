/*
 * @lc app=leetcode id=1284 lang=java
 *
 * [1284] Minimum Number of Flips to Convert Binary Matrix to Zero Matrix
 *
 * https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/description/
 *
 * algorithms
 * Hard (69.38%)
 * Likes:    139
 * Dislikes: 23
 * Total Accepted:    7.2K
 * Total Submissions: 10.4K
 * Testcase Example:  '[[0,0],[0,1]]\r'
 *
 * Given a m x n binary matrix mat. In one step, you can choose one cell and
 * flip it and all the four neighbours of it if they exist (Flip is changing 1
 * to 0 and 0 to 1). A pair of cells are called neighboors if they share one
 * edge.
 *
 * Return the minimum number of steps required to convert mat to a zero matrix
 * or -1 if you cannot.
 *
 * Binary matrix is a matrix with all cells equal to 0 or 1 only.
 *
 * Zero matrix is a matrix with all cells equal to 0.
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[0,0],[0,1]]
 * Output: 3
 * Explanation: One possible solution is to flip (1, 0) then (0, 1) and finally
 * (1, 1) as shown.
 *
 *
 * Example 2:
 *
 *
 * Input: mat = [[0]]
 * Output: 0
 * Explanation: Given matrix is a zero matrix. We don't need to change it.
 *
 *
 * Example 3:
 *
 *
 * Input: mat = [[1,1,1],[1,0,1],[0,0,0]]
 * Output: 6
 *
 *
 * Example 4:
 *
 *
 * Input: mat = [[1,0,0],[1,0,0]]
 * Output: -1
 * Explanation: Given matrix can't be a zero matrix
 *
 *
 *
 * Constraints:
 *
 *
 * m == mat.length
 * n == mat[0].length
 * 1 <= m <= 3
 * 1 <= n <= 3
 * mat[i][j] is 0 or 1.
 *
 *
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    private final int[] nextI = {-1, 0, 0, 1};
    private final int[] nextJ = {0, -1, 1, 0};

    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < Math.pow(2, m * n); i++) {
            int temp = i;
            int[][] copy = copy(mat, m, n);
            int countBits = 0;
            for (int j = 0; j < m && temp > 0; j++) {
                for (int k = 0; k < n && temp > 0; k++) {
                    if (temp % 2 != 0) {
                        flip(copy, j, k);
                        countBits++;
                    }
                    temp /= 2;
                }
            }
            if (isZero(copy)) {
                result = Math.min(result, countBits);
            }
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    private int[][] copy(int[][] mat, int m, int n) {
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            copy[i] = Arrays.copyOf(mat[i], n);
        }
        return copy;
    }

    private void flip(int[][] mat, int i, int j) {
        mat[i][j] = mat[i][j] == 0 ? 1 : 0;
        for (int x = 0; x < 4; x++) {
            int tempI = i + nextI[x];
            int tempJ = j + nextJ[x];
            if (tempI >= 0 && tempI < mat.length && tempJ >= 0 && tempJ < mat[0].length) {
                mat[tempI][tempJ] = mat[tempI][tempJ] == 0 ? 1 : 0;
            }
        }
    }

    private boolean isZero(int[][] mat) {
        for (int[] i : mat) {
            for (int j : i) {
                if (j == 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
// @lc code=end
