/*
 * @lc app=leetcode id=1118 lang=java
 *
 * [1118] Number of Days in a Month
 *
 * https://leetcode.com/problems/number-of-days-in-a-month/description/
 *
 * algorithms
 * Easy (56.44%)
 * Likes:    10
 * Dislikes: 68
 * Total Accepted:    3.1K
 * Total Submissions: 5.5K
 * Testcase Example:  '1992\n7'
 *
 * Given a year Y and a month M, return how many days there are in that
 * month.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: Y = 1992, M = 7
 * Output: 31
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: Y = 2000, M = 2
 * Output: 29
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: Y = 1900, M = 2
 * Output: 28
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1583 <= Y <= 2100
 * 1 <= M <= 12
 * 
 * 
 */

// @lc code=start
class Solution {

    public int numberOfDays(int Y, int M) {
        int[] daysNormalYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if((Y % 4 == 0 && Y % 100 != 0) || Y % 400 == 0) {
            return daysLeapYear[M-1];
        }
        return daysNormalYear[M-1];
    }

}
// @lc code=end
