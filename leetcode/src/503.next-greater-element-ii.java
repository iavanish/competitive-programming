/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 *
 * https://leetcode.com/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (55.53%)
 * Likes:    1372
 * Dislikes: 68
 * Total Accepted:    89.7K
 * Total Submissions: 161.4K
 * Testcase Example:  '[1,2,1]'
 *
 *
 * Given a circular array (the next element of the last element is the first
 * element of the array), print the Next Greater Number for every element. The
 * Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, output -1 for this
 * number.
 *
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2; The number 2 can't find
 * next greater number; The second 1's next greater number needs to search
 * circularly, which is also 2.
 *
 *
 *
 * Note:
 * The length of given array won't exceed 10000.
 *
 */

import java.util.Stack;

// @lc code=start
class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = nums[i];
            while (!stack.isEmpty() && stack.peek() <= temp) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nums[i] = stack.peek();
            } else {
                nums[i] = -1;
            }
            stack.push(temp);
        }

        return nums;
    }

}
// @lc code=end
