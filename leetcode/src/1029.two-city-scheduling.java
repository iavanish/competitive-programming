/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 *
 * https://leetcode.com/problems/two-city-scheduling/description/
 *
 * algorithms
 * Easy (56.40%)
 * Likes:    1237
 * Dislikes: 161
 * Total Accepted:    79.7K
 * Total Submissions: 141.4K
 * Testcase Example:  '[[10,20],[30,200],[400,50],[30,20]]'
 *
 * There are 2N people a company is planning to interview. The cost of flying
 * the i-th person to city A is costs[i][0], and the cost of flying the i-th
 * person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N
 * people arrive in each city.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people
 * interviewing in each city.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 *
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    private int[][] dp;

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        dp = new int[n / 2 + 1][n / 2 + 1];
        for (int i = 0; i < n / 2 + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return twoCitySchedCost(costs, 0, n / 2, n / 2);
    }

    private int twoCitySchedCost(int[][] costs, int i, int n1, int n2) {
        if (costs.length == i) {
            return 0;
        }
        if (dp[n1][n2] != -1) {
            return dp[n1][n2];
        }
        int minCost = Integer.MAX_VALUE;
        if (n1 > 0) {
            minCost = costs[i][0] + twoCitySchedCost(costs, i + 1, n1 - 1, n2);
        }
        if (n2 > 0) {
            minCost = Math.min(minCost, costs[i][1] + twoCitySchedCost(costs, i + 1, n1, n2 - 1));
        }
        return dp[n1][n2] = minCost;
    }

}
// @lc code=end
