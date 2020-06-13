/*
 * @lc app=leetcode id=1074 lang=java
 *
 * [1074] Number of Submatrices That Sum to Target
 *
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/description/
 *
 * algorithms
 * Hard (59.36%)
 * Likes:    449
 * Dislikes: 23
 * Total Accepted:    14.5K
 * Total Submissions: 24.5K
 * Testcase Example:  '[[0,1,0],[1,1,1],[0,1,0]]\n0'
 *
 * Given a matrix, and a target, return the number of non-empty submatrices
 * that sum to target.
 *
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x
 * <= x2 and y1 <= y <= y2.
 *
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if
 * they have some coordinate that is different: for example, if x1 != x1'.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.
 *
 *
 *
 * Example 2:
 *
 *
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the
 * 2x2 submatrix.
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= matrix.length <= 300
 * 1 <= matrix[0].length <= 300
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 *
 *
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Map<Integer, Integer> dp = new HashMap<>();
                dp.put(0, 1);
                int sum = 0;
                for (int[] elements : matrix) {
                    sum += elements[j] - (i > 0 ? elements[i - 1] : 0);
                    count += dp.getOrDefault(sum - target, 0);
                    dp.put(sum, dp.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }

}
// @lc code=end
