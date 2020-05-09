/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 *
 * https://leetcode.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (41.06%)
 * Likes:    752
 * Dislikes: 159
 * Total Accepted:    189.5K
 * Total Submissions: 457.6K
 * Testcase Example:  '16'
 *
 * Given a positive integer num, write a function which returns True if num is
 * a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 *
 *
 * Input: 16
 * Output: true
 *
 *
 *
 * Example 2:
 *
 *
 * Input: 14
 * Output: false
 *
 *
 *
 */

// @lc code=start
class Solution {

    public boolean isPerfectSquare(long num) {
        if (num == 1) {
            return true;
        }

        long left = 1;
        long right = num;
        while (left <= right) {
            long middle = left + (right - left) / 2;
            if (middle * middle == num) {
                return true;
            }
            else if (middle * middle < num) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return false;
    }

}
// @lc code=end
