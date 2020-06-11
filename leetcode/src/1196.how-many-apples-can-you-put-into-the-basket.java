/*
 * @lc app=leetcode id=1196 lang=java
 *
 * [1196] How Many Apples Can You Put into the Basket
 *
 * https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/description/
 *
 * algorithms
 * Easy (67.73%)
 * Likes:    32
 * Dislikes: 8
 * Total Accepted:    5.4K
 * Total Submissions: 8K
 * Testcase Example:  '[100,200,150,1000]'
 *
 * You have some apples, where arr[i] is the weight of the i-th apple.  You
 * also have a basket that can carry up to 5000 units of weight.
 *
 * Return the maximum number of apples you can put in the basket.
 *
 *
 * Example 1:
 *
 *
 * Input: arr = [100,200,150,1000]
 * Output: 4
 * Explanation: All 4 apples can be carried by the basket since their sum of
 * weights is 1450.
 *
 *
 * Example 2:
 *
 *
 * Input: arr = [900,950,800,1000,700,800]
 * Output: 5
 * Explanation: The sum of weights of the 6 apples exceeds 5000 so we choose
 * any 5 of them.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= arr.length <= 10^3
 * 1 <= arr[i] <= 10^3
 *
 *
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    public int maxNumberOfApples(int[] arr) {
        int maxApples = 0;
        int sum = 0;
        Arrays.sort(arr);
        while (maxApples < arr.length && sum + arr[maxApples] <= 5000) {
            sum += arr[maxApples++];
        }

        return maxApples;
    }

}
// @lc code=end
