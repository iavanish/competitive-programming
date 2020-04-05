/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (55.26%)
 * Likes:    2617
 * Dislikes: 206
 * Total Accepted:    529.1K
 * Total Submissions: 940.8K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */

// @lc code=start
class Solution {

    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majorityElement = nums[0];
        int majorityCount = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == majorityElement) {
                majorityCount++;
            }
            else {
                majorityCount--;
                if (majorityCount == 0) {
                    majorityElement = nums[i];
                    majorityCount++;
                }
            }
        }

        return majorityElement;
    }

}
// @lc code=end
