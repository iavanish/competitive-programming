/*
 * @lc app=leetcode id=1134 lang=java
 *
 * [1134] Armstrong Number
 *
 * https://leetcode.com/problems/armstrong-number/description/
 *
 * algorithms
 * Easy (77.81%)
 * Likes:    33
 * Dislikes: 5
 * Total Accepted:    8.1K
 * Total Submissions: 10.4K
 * Testcase Example:  '153'
 *
 * The k-digit number N is an Armstrong number if and only if the k-th power of
 * each digit sums to N.
 *
 * Given a positive integer N, return true if and only if it is an Armstrong
 * number.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: 153
 * Output: true
 * Explanation:
 * 153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
 *
 *
 * Example 2:
 *
 *
 * Input: 123
 * Output: false
 * Explanation:
 * 123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 = 36.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= N <= 10^8
 *
 *
 */

// @lc code=start
class Solution {

    public boolean isArmstrong(int N) {
        int k = String.valueOf(N).length();
        int temp = N;
        int sum = 0;
        while (temp > 0 && sum < N) {
            int remainder = temp % 10;
            temp /= 10;
            sum += Math.pow(remainder, k);
        }

        return temp == 0 && sum == N;
    }

}
// @lc code=end
