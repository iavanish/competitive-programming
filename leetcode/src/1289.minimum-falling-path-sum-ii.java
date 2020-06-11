/*
 * @lc app=leetcode id=1289 lang=java
 *
 * [1289] Minimum Falling Path Sum II
 *
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/description/
 *
 * algorithms
 * Hard (60.66%)
 * Likes:    150
 * Dislikes: 16
 * Total Accepted:    7.9K
 * Total Submissions: 13K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a square grid of integers arr, a falling path with non-zero shifts is
 * a choice of exactly one element from each row of arr, such that no two
 * elements chosen in adjacent rows are in the same column.
 *
 * Return the minimum sum of a falling path with non-zero shifts.
 *
 *
 * Example 1:
 *
 *
 * Input: arr = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 13
 * Explanation:
 * The possible falling paths are:
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * The falling path with the smallest sum is [1,5,7], so the answer is 13.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= arr.length == arr[i].length <= 200
 * -99 <= arr[i][j] <= 99
 *
 *
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    private Integer[][] dp;

    public int minFallingPathSum(int[][] arr) {
        dp = new Integer[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], null);
        }

        int minFallingPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            minFallingPathSum = Math.min(minFallingPathSum, minFallingPathSum(arr, 0, i));
        }

        return minFallingPathSum;
    }

    private int minFallingPathSum(int[][] arr, int i, int j) {
        if (arr.length == i) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int minFallingPathSum = Integer.MAX_VALUE;
        for (int x = 0; x < arr[0].length; x++) {
            if (j != x) {
                minFallingPathSum = Math.min(minFallingPathSum, minFallingPathSum(arr, i + 1, x));
            }
        }
        return dp[i][j] = arr[i][j] + minFallingPathSum;
    }

}
// @lc code=end
