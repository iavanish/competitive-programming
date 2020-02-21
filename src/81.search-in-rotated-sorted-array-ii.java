/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (32.85%)
 * Likes:    964
 * Dislikes: 406
 * Total Accepted:    209.6K
 * Total Submissions: 636.8K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * 
 * 
 * This is a follow up problem to Search in Rotated Sorted Array, where nums
 * may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * 
 * 
 */

// @lc code=start
class Solution {

    public boolean search(int[] nums, int target) {
        if(nums.length == 0) {
            return false;
        }

        int first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            int middle = first + (last - first) / 2;
            if (nums[middle] == target) {
                return true;
            }
            else if (nums[first] <= nums[middle] && nums[middle] <= nums[last]) {
                if (nums[first] == target) {
                    return true;
                }
                first++;
            }
            else if (nums[first] <= nums[middle]) {
                if (nums[first] <= target && target < nums[middle]) {
                    last = middle - 1;
                }
                else {
                    first = middle + 1;
                }
            }
            else {
                if (nums[middle] < target && target <= nums[last]) {
                    first = middle + 1;
                }
                else {
                    last = middle - 1;
                }
            }
        }
        return false;
    }

}
// @lc code=end
