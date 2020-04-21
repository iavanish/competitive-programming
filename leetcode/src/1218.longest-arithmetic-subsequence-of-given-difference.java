/*
 * @lc app=leetcode id=1218 lang=java
 *
 * [1218] Longest Arithmetic Subsequence of Given Difference
 *
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/
 *
 * algorithms
 * Medium (40.93%)
 * Likes:    186
 * Dislikes: 18
 * Total Accepted:    10.5K
 * Total Submissions: 25.2K
 * Testcase Example:  '[1,2,3,4]\n1'
 *
 * Given an integer array arr and an integer difference, return the length of
 * the longest subsequence in arr which is an arithmetic sequence such that the
 * difference between adjacent elements in the subsequence equals
 * difference.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [1,2,3,4], difference = 1
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [1,2,3,4].
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [1,3,5,7], difference = 1
 * Output: 1
 * Explanation: The longest arithmetic subsequence is any single element.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * Output: 4
 * Explanation: The longest arithmetic subsequence is [7,5,3,1].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i], difference <= 10^4
 * 
 * 
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> mem = new HashMap<>();
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            int temp = mem.getOrDefault(arr[i], 0);
            int prev = mem.getOrDefault(arr[i] - difference, 0);
            if(temp < prev + 1) {
                mem.put(arr[i], prev + 1);
                max = Math.max(max, prev + 1);
            }
        }

        return max;
    }

}
// @lc code=end
