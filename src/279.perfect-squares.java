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
        numSquares[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                numSquares[i] = 1;
            }
            else {
                numSquares[i] = Integer.MAX_VALUE;
                for (int j = 1; j < i; j++) {
                    numSquares[i] = Math.min(numSquares[i], numSquares[j] + numSquares[i-j]);
                }
            }
        }
        return numSquares[n];
    }

}
// @lc code=end
