/*
 * @lc app=leetcode id=1438 lang=java
 *
 * [1438] Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 *
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
 *
 * algorithms
 * Medium (38.88%)
 * Likes:    249
 * Dislikes: 5
 * Total Accepted:    9.1K
 * Total Submissions: 23.3K
 * Testcase Example:  '[8,2,4,7]\n4'
 *
 * Given an array of integers nums and an integer limit, return the size of the
 * longest continuous subarray such that the absolute difference between any
 * two elements is less than or equal to limit.
 *
 * In case there is no subarray satisfying the given condition return 0.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum
 * absolute diff is |2-7| = 5 <= 5.
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 *
 *
 */

import java.util.Deque;
import java.util.LinkedList;

// @lc code=start
class Solution {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        int start = 0;
        int end;
        int result = 0;

        for (end = 0; end < nums.length; end++) {
            while (!minQueue.isEmpty() && nums[minQueue.peekLast()] > nums[end]) {
                minQueue.pollLast();
            }
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] < nums[end]) {
                maxQueue.pollLast();
            }
            minQueue.offerLast(end);
            maxQueue.offerLast(end);

            while (nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > limit) {
                if (minQueue.peekFirst() == start) {
                    minQueue.pollFirst();
                }
                else if (maxQueue.peekFirst() == start) {
                    maxQueue.pollFirst();
                }
                start++;
            }

            result = Math.max(result, end-start+1);
        }

        return result;
    }

}
// @lc code=end
