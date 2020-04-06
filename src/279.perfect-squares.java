/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (43.84%)
 * Likes:    2270
 * Dislikes: 173
 * Total Accepted:    254.9K
 * Total Submissions: 567.4K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

// @lc code=start
class Solution {

    public int numSquares(int n) {
        int[] numSquares = new int[n+1];
        numSquares[0] = 0;
        for (int i = 1; i <= n; i++) {
            numSquares[i] = i;
            for (int j = 0; j * j <= i; j++) {
                numSquares[i] = Math.min(numSquares[i], numSquares[i-j*j] + 1);
            }
        }

        return numSquares[n];
    }

}
// @lc code=end
