/*
 * @lc app=leetcode id=719 lang=java
 *
 * [719] Find K-th Smallest Pair Distance
 *
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
 *
 * algorithms
 * Hard (30.29%)
 * Likes:    746
 * Dislikes: 25
 * Total Accepted:    27.1K
 * Total Submissions: 88.7K
 * Testcase Example:  '[1,3,1]\n1'
 *
 * Given an integer array, return the k-th smallest distance among all the
 * pairs. The distance of a pair (A, B) is defined as the absolute difference
 * between A and B.
 *
 * Example 1:
 *
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 *
 *
 *
 * Note:
 *
 * 2 .
 * 0 .
 * 1 .
 *
 *
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums[nums.length - 1] - nums[0];
        while (start < end) {
            int middle = start + (end - start) / 2;
            int count = 0;
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                while (nums[j] - nums[i] > middle) {
                    i++;
                }
                count += (j - i);
            }
            if (count < k) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return start;
    }

}
// @lc code=end
