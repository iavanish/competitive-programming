/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/description/
 *
 * algorithms
 * Medium (42.31%)
 * Likes:    1295
 * Dislikes: 1751
 * Total Accepted:    308.4K
 * Total Submissions: 724.9K
 * Testcase Example:  '[1,2,3,1]'
 *
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element
 * and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5 
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2, 
 * or index number 5 where the peak element is 6.
 * 
 * 
 * Note:
 * 
 * Your solution should be in logarithmic complexity.
 * 
 */

// @lc code=start
class Solution {

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] < nums[1] ? 1 : 0;
        }

        int first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            int middle = first + (last - first) / 2;
            int prev = middle == 0 ? Integer.MIN_VALUE : nums[middle-1];
            int next = middle == nums.length - 1 ? Integer.MIN_VALUE : nums[middle+1];
            if (prev < nums[middle] && next < nums[middle]) {
                return middle;
            }
            else if (prev < next) {
                first = middle + 1;
            }
            else {
                last = middle - 1;
            }
        }

        return -1;
    }

}
// @lc code=end
