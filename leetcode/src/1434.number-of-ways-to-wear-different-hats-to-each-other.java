/*
 * @lc app=leetcode id=1434 lang=java
 *
 * [1434] Number of Ways to Wear Different Hats to Each Other
 *
 * https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/description/
 *
 * algorithms
 * Hard (20.86%)
 * Likes:    58
 * Dislikes: 2
 * Total Accepted:    747
 * Total Submissions: 3.7K
 * Testcase Example:  '[[3,4],[4,5],[5]]'
 *
 * There are n people and 40 types of hats labeled from 1 to 40.
 *
 * Given a list of list of integers hats, where hats[i] is a list of all hats
 * preferred by the i-th person.
 *
 * Return the number of ways that the n people wear different hats to each
 * other.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 * Example 1:
 *
 *
 * Input: hats = [[3,4],[4,5],[5]]
 * Output: 1
 * Explanation: There is only one way to choose hats given the conditions.
 * First person choose hat 3, Second person choose hat 4 and last one hat 5.
 *
 * Example 2:
 *
 *
 * Input: hats = [[3,5,1],[3,5]]
 * Output: 4
 * Explanation: There are 4 ways to choose hats
 * (3,5), (5,3), (1,3) and (1,5)
 *
 *
 * Example 3:
 *
 *
 * Input: hats = [[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]
 * Output: 24
 * Explanation: Each person can choose hats labeled from 1 to 4.
 * Number of Permutations of (1,2,3,4) = 24.
 *
 *
 * Example 4:
 *
 *
 * Input: hats = [[1,2,3],[2,3,5,6],[1,3,7,9],[1,8,9],[2,5,7]]
 * Output: 111
 *
 *
 *
 * Constraints:
 *
 *
 * n == hats.length
 * 1 <= n <= 10
 * 1 <= hats[i].length <= 40
 * 1 <= hats[i][j] <= 40
 * hats[i] contains a list of unique integers.
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {

    public int numberWays(List<List<Integer>> hats) {
        List<List<Integer>> whoCanWear = new ArrayList<>();
        for (int i = 0; i < 41; i++) {
            whoCanWear.add(new ArrayList<>());
        }
        for (int i = 0; i < hats.size(); i++) {
            for (Integer hat : hats.get(i)) {
                whoCanWear.get(hat).add(i);
            }
        }

        long[][] dp = new long[41][1024];
        for (int i = 0; i < 41; i++) {
            Arrays.fill(dp[i], -1);
        }
        return (int) numberWays(whoCanWear, (1 << hats.size()) - 1, 0, 1, dp);
    }

    private long mod = 1_000_000_007;

    private long numberWays(List<List<Integer>> whoCanWear, int mask, int chosen, int hat, long[][] dp) {
        if (mask == chosen) {
            return 1;
        }
        else if (hat == 41) {
            return 0;
        }
        if (dp[hat][chosen] != -1) {
            return dp[hat][chosen];
        }
        long result = numberWays(whoCanWear, mask, chosen, hat+1, dp) % mod;
        for (Integer who : whoCanWear.get(hat)) {
            if (((chosen >> who) & 1) == 0) {
                result += (numberWays(whoCanWear, mask, chosen | (1 << who), hat+1, dp) % mod);
                result %= mod;
            }
        }
        dp[hat][chosen] = result;
        return result;
    }

}
// @lc code=end
