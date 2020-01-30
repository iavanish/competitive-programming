/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (45.29%)
 * Likes:    6122
 * Dislikes: 254
 * Total Accepted:    752.9K
 * Total Submissions: 1.7M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */

// @lc code=start
class Solution {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i-1] + nums[i]);
            max = Math.max(max, nums[i]);
        }

        return max;
    }

}
// @lc code=end
