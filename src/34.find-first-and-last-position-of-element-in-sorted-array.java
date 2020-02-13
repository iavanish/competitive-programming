/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (34.76%)
 * Likes:    2535
 * Dislikes: 116
 * Total Accepted:    415.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */

// @lc code=start
class Solution {

    public int[] searchRange(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        int index = binarySearch(nums, target, first, last);
        if(index == -1) {
            return new int[]{-1, -1};
        }
        int start = index;
        int end = index;
        while(index > 0 && nums[index-1] == target) {
            index = binarySearch(nums, target, first, index-1);
            if(index != -1) {
                start = index;
            }
        }
        index = end;
        while(index < last && nums[index+1] == target) {
            index = binarySearch(nums, target, index+1, last);
            if(index != -1) {
                end = index;
            }
        }
        return new int[] {start, end};
    }

    private int binarySearch(int[] nums, int target, int first, int last) {
        while(first <= last) {
            int middle = first + (last - first) / 2;
            if(nums[middle] == target) {
                return middle;
            }
            else if(target < nums[middle]) {
                last = middle - 1;
            }
            else {
                first = middle + 1;
            }
        }
        return -1;
    }

}
// @lc code=end
