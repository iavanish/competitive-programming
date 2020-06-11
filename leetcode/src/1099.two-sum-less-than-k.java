/*
 * @lc app=leetcode id=1099 lang=java
 *
 * [1099] Two Sum Less Than K
 *
 * https://leetcode.com/problems/two-sum-less-than-k/description/
 *
 * algorithms
 * Easy (60.31%)
 * Likes:    203
 * Dislikes: 25
 * Total Accepted:    23.7K
 * Total Submissions: 39.2K
 * Testcase Example:  '[34,23,1,24,75,33,54,8]\n60'
 *
 * Given an array A of integers and integer K, return the maximum S such that
 * there exists i < j with A[i] + A[j] = S and S < K. If no i, j exist
 * satisfying this equation, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: A = [34,23,1,24,75,33,54,8], K = 60
 * Output: 58
 * Explanation:
 * We can use 34 and 24 to sum 58 which is less than 60.
 *
 *
 * Example 2:
 *
 *
 * Input: A = [10,20,30], K = 15
 * Output: -1
 * Explanation:
 * In this case it's not possible to get a pair sum less that 15.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= A.length <= 100
 * 1 <= A[i] <= 1000
 * 1 <= K <= 2000
 *
 *
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int max = -1;
        for (int i = A.length - 1; i > 0; i--) {
            int index = Arrays.binarySearch(A, 0, i, K - A[i] - 1);
            if (index >= 0) {
                return K - 1;
            }
            index *= -1;
            index -= 2;
            if (index >= 0 && A[i] + A[index] < K) {
                max = Math.max(max, A[i] + A[index]);
            }
        }

        return max;
    }

}
// @lc code=end
