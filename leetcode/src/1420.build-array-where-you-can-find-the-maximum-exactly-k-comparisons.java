/*
 * @lc app=leetcode id=1420 lang=java
 *
 * [1420] Build Array Where You Can Find The Maximum Exactly K Comparisons
 *
 * https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/description/
 *
 * algorithms
 * Hard (67.12%)
 * Likes:    104
 * Dislikes: 5
 * Total Accepted:    3.5K
 * Total Submissions: 5.2K
 * Testcase Example:  '2\n3\n1'
 *
 * Given three integers n, m and k. Consider the following algorithm to find
 * the maximum element of an array of positive integers:
 *
 * You should build the array arr which has the following properties:
 *
 *
 * arr has exactly n integers.
 * 1 <= arr[i] <= m where (0 <= i < n).
 * After applying the mentioned algorithm to arr, the value search_cost is
 * equal to k.
 *
 *
 * Return the number of ways to build the array arr under the mentioned
 * conditions. As the answer may grow large, the answer must be computed modulo
 * 10^9 + 7.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 2, m = 3, k = 1
 * Output: 6
 * Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2]
 * [3, 3]
 *
 *
 * Example 2:
 *
 *
 * Input: n = 5, m = 2, k = 3
 * Output: 0
 * Explanation: There are no possible arrays that satisify the mentioned
 * conditions.
 *
 *
 * Example 3:
 *
 *
 * Input: n = 9, m = 1, k = 1
 * Output: 1
 * Explanation: The only possible array is [1, 1, 1, 1, 1, 1, 1, 1, 1]
 *
 *
 * Example 4:
 *
 *
 * Input: n = 50, m = 100, k = 25
 * Output: 34549172
 * Explanation: Don't forget to compute the answer modulo 1000000007
 *
 *
 * Example 5:
 *
 *
 * Input: n = 37, m = 17, k = 7
 * Output: 418930126
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 50
 * 1 <= m <= 100
 * 0 <= k <= n
 *
 */

// @lc code=start
class Solution {

    public int numOfArrays(int n, int m, int k) {
        long mod = 1000000007;
        long[][][] dp = new long[n+1][m+1][k+1];

        for (int i = 1; i <= m; i++) {
            dp[1][i][1] = 1;
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= m; b++) {
                for (int c = 1; c <= k; c++) {
                    long s = (b * dp[a-1][b][c]) % mod;
                    for (int i = 1; i < b; i++) {
                        s += dp[a-1][i][c-1];
                        s %= mod;
                    }
                    dp[a][b][c] += s;
                    dp[a][b][c] %= mod;
                }
            }
        }

        int numOfArrays = 0;
        for (int i = 1; i <= m; i++) {
            numOfArrays += dp[n][i][k];
            numOfArrays %= mod;
        }
        return numOfArrays;
    }

}
// @lc code=end
