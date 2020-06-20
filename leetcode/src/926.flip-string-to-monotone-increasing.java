/*
 * @lc app=leetcode id=926 lang=java
 *
 * [926] Flip String to Monotone Increasing
 *
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/description/
 *
 * algorithms
 * Medium (51.92%)
 * Likes:    552
 * Dislikes: 18
 * Total Accepted:    20.6K
 * Total Submissions: 39.7K
 * Testcase Example:  '"00110"'
 *
 * A string of '0's and '1's is monotone increasing if it consists of some
 * number of '0's (possibly 0), followed by some number of '1's (also possibly
 * 0.)
 *
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1'
 * or a '1' to a '0'.
 *
 * Return the minimum number of flips to make S monotone increasing.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 *
 *
 *
 * Example 3:
 *
 *
 * Input: "00011000"
 * Output: 2
 * Explanation: We flip to get 00000000.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= S.length <= 20000
 * S only consists of '0' and '1' characters.
 *
 *
 *
 *
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    private int[][] dp;

    public int minFlipsMonoIncr(String S) {
        dp = new int[2][S.length()];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return minFlipsMonoIncr(S, 0, false);
    }

    private int minFlipsMonoIncr(String s, int i, boolean zeroEnded) {
        if (s.length() == i) {
            return 0;
        }
        if (dp[zeroEnded ? 0 : 1][i] != -1) {
            return dp[zeroEnded ? 0 : 1][i];
        }
        int minFlipsMonoIncr = Integer.MAX_VALUE;
        if (!zeroEnded) {
            minFlipsMonoIncr = (s.charAt(i) == '0' ? 0 : 1) + minFlipsMonoIncr(s, i + 1, false);
        }
        minFlipsMonoIncr = Math.min(minFlipsMonoIncr, (s.charAt(i) == '0' ? 1 : 0) + minFlipsMonoIncr(s, i + 1, true));
        return dp[zeroEnded ? 0 : 1][i] = minFlipsMonoIncr;
    }

}
// @lc code=end
