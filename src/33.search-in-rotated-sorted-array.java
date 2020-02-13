/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (33.48%)
 * Likes:    3688
 * Dislikes: 402
 * Total Accepted:    569.1K
 * Total Submissions: 1.7M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */

// @lc code=start
class Solution {

    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }

        int partitionPoint = partitionPoint(nums);
        if(partitionPoint > 0 && nums[partitionPoint] < nums[partitionPoint-1]) {
            partitionPoint--;
        }
        int index1 = binarySearch(nums, target, 0, partitionPoint);
        int index2 = binarySearch(nums, target, partitionPoint+1, nums.length-1);
        return Math.max(index1, index2);
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

    private int partitionPoint(int[] nums) {
        int first = 0;
        int last = nums.length-1;
        while(first < last) {
            int middle = first + (last - first) / 2;
            if(nums[first] < nums[middle]) {
                first = middle;
            }
            else {
                last = middle;
            }
        }
        return first;
    }

}
// @lc code=end
