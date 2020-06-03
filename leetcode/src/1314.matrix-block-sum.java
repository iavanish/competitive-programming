/*
 * @lc app=leetcode id=1314 lang=java
 *
 * [1314] Matrix Block Sum
 *
 * https://leetcode.com/problems/matrix-block-sum/description/
 *
 * algorithms
 * Medium (73.27%)
 * Likes:    270
 * Dislikes: 56
 * Total Accepted:    11.8K
 * Total Submissions: 16K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]\n1'
 *
 * Given a m * n matrix mat and an integer K, return a matrix answer where each
 * answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j
 * - K <= c <= j + K, and (r, c) is a valid position in the matrix.
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * Output: [[12,21,16],[27,45,33],[24,39,28]]
 *
 *
 * Example 2:
 *
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * Output: [[45,45,45],[45,45,45],[45,45,45]]
 *
 *
 *
 * Constraints:
 *
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 *
 */

// @lc code=start
class Solution {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0) {
                    mat[i][j] += mat[i - 1][j];
                }
                if (j != 0) {
                    mat[i][j] += mat[i][j - 1];
                }
                if (i != 0 && j != 0) {
                    mat[i][j] -= mat[i - 1][j - 1];
                }
            }
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tempI = Math.min(m - 1, i + K);
                int tempJ = Math.min(n - 1, j + K);
                result[i][j] = mat[tempI][tempJ];
                if (i - K - 1 >= 0) {
                    result[i][j] -= mat[i - K - 1][tempJ];
                }
                if (j - K - 1 >= 0) {
                    result[i][j] -= mat[tempI][j - K - 1];
                }
                if (i - K - 1 >= 0 && j - K - 1 >= 0) {
                    result[i][j] += mat[i - K - 1][j - K - 1];
                }
            }
        }

        return result;
    }

}
// @lc code=end
