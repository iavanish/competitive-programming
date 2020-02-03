/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (41.73%)
 * Likes:    1548
 * Dislikes: 184
 * Total Accepted:    218.9K
 * Total Submissions: 520.2K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */

import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if(m == 0) {
            return 0;
        }
        int n = triangle.get(m-1).size();
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return triangle.get(0).get(0);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < m; i++) {
            int first = Integer.MAX_VALUE;
            int second = dp[0];
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(first, second);
                first = second;
                if(j < n-1) {
                    second = dp[j + 1];
                }
            }
        }

        int min = dp[0];
        for(int i = 1; i < n; i++) {
            min = Math.min(min, dp[i]);
        }

        return min;
    }

}
// @lc code=end
