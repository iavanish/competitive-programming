/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (43.99%)
 * Likes:    1593
 * Dislikes: 207
 * Total Accepted:    374.9K
 * Total Submissions: 848.6K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 * 
 */

// @lc code=start
class Solution {

    public int findMin(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            int middle = first + (last - first) / 2;
            if (nums[first] <= nums[middle] && nums[middle] <= nums[last]) {
                if (nums[first] <= nums[last]) {
                    return nums[first];
                }
                first++;
                last--;
            }
            else if (nums[middle] <= nums[first] && nums[middle] <= nums[last]) {
                first++;
                last--;
            }
            else if (nums[first] <= nums[middle]) {
                first = middle + 1;
            }
            else {
                last = middle - 1;
            }
        }
        return nums[first];
    }

}
// @lc code=end
