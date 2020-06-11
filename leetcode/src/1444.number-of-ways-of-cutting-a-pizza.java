/*
 * @lc app=leetcode id=1444 lang=java
 *
 * [1444] Number of Ways of Cutting a Pizza
 *
 * https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/description/
 *
 * algorithms
 * Hard (39.78%)
 * Likes:    2
 * Dislikes: 0
 * Total Accepted:    735
 * Total Submissions: 1.8K
 * Testcase Example:  '["A..","AAA","..."]\n3'
 *
 * Given a rectangular pizza represented as a rows x cols matrix containing the
 * following characters: 'A' (an apple) and '.' (empty cell) and given the
 * integer k. You have to cut the pizza into k pieces using k-1 cuts. 
 *
 * For each cut you choose the direction: vertical or horizontal, then you
 * choose a cut position at the cell boundary and cut the pizza into two
 * pieces. If you cut the pizza vertically, give the left part of the pizza to
 * a person. If you cut the pizza horizontally, give the upper part of the
 * pizza to a person. Give the last piece of pizza to the last person.
 *
 * Return the number of ways of cutting the pizza such that each piece contains
 * at least one apple. Since the answer can be a huge number, return this
 * modulo 10^9 + 7.
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input: pizza = ["A..","AAA","..."], k = 3
 * Output: 3
 * Explanation: The figure above shows the three ways to cut the pizza. Note
 * that pieces must contain at least one apple.
 *
 *
 * Example 2:
 *
 *
 * Input: pizza = ["A..","AA.","..."], k = 3
 * Output: 1
 *
 *
 * Example 3:
 *
 *
 * Input: pizza = ["A..","A..","..."], k = 1
 * Output: 1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= rows, cols <= 50
 * rows == pizza.length
 * cols == pizza[i].length
 * 1 <= k <= 10
 * pizza consists of characters 'A' and '.' only.
 *
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    private long mod = 1_000_000_007;

    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] p = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = (i != 0 ? p[i - 1][j] : 0) + (j != 0 ? p[i][j - 1] : 0) - (i != 0 && j != 0 ? p[i - 1][j - 1] : 0);
                if (pizza[i].charAt(j) == 'A') {
                    p[i][j]++;
                }
            }
        }

        long[][][] dp = new long[m][n][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return (int) ways(p, 0, 0, m - 1, n - 1, k - 1, dp);
    }

    private long ways(int[][] pizza, int leftR, int leftC, int rightR, int rightC, int k, long[][][] dp) {
        if (k == 0) {
            return 1;
        }

        if (dp[leftR][leftC][k] != -1) {
            return dp[leftR][leftC][k];
        }

        long ways = 0;

        for (int i = leftR + 1; i <= rightR; i++) {
            if (countPizza(pizza, leftR, leftC, i - 1, rightC) > 0 && countPizza(pizza, i, leftC, rightR, rightC) > 0) {
                ways += ways(pizza, i, leftC, rightR, rightC, k - 1, dp);
                ways %= mod;
            }
        }

        for (int i = leftC + 1; i <= rightC; i++) {
            if (countPizza(pizza, leftR, leftC, rightR, i - 1) > 0 && countPizza(pizza, leftR, i, rightR, rightC) > 0) {
                ways += ways(pizza, leftR, i, rightR, rightC, k - 1, dp);
                ways %= mod;
            }
        }

        dp[leftR][leftC][k] = ways;
        return ways;
    }

    private int countPizza(int[][] pizza, int leftR, int leftC, int rightR, int rightC) {
        return pizza[rightR][rightC] -
                (leftR != 0 ? pizza[leftR - 1][rightC] : 0) -
                (leftC != 0 ? pizza[rightR][leftC - 1] : 0) +
                (leftR != 0 && leftC != 0 ? pizza[leftR - 1][leftC - 1] : 0);
    }

}
// @lc code=end
