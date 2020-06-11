/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (40.08%)
 * Likes:    660
 * Dislikes: 190
 * Total Accepted:    159.1K
 * Total Submissions: 395.2K
 * Testcase Example:  '[1,3,5]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 *
 * Input: [1,3,5]
 * Output: 1
 *
 * Example 2:
 *
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 *
 * Note:
 *
 *
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 *
 *
 */

// @lc code=start
class Solution {

    public int findMin(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            if (first == last) {
                return nums[first];
            }
            int middle = first + (last - first) / 2;
            if (nums[first] <= nums[middle] && nums[middle] <= nums[last]) {
                if (nums[first] < nums[last]) {
                    return nums[first];
                }
                first++;
                last--;
            } else if (nums[middle] <= nums[first] && nums[middle] <= nums[last]) {
                first++;
                last--;
            } else if (nums[first] <= nums[middle]) {
                first = middle + 1;
            } else {
                last = middle - 1;
            }
        }
        return nums[first];
    }

}
// @lc code=end
