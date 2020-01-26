/*
 * @lc app=leetcode id=1304 lang=java
 *
 * [1304] Find N Unique Integers Sum up to Zero
 *
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/
 *
 * algorithms
 * Easy (78.55%)
 * Likes:    90
 * Dislikes: 50
 * Total Accepted:    15.2K
 * Total Submissions: 19.7K
 * Testcase Example:  '5'
 *
 * Given an integer n, return any array containing n unique integers such that
 * they add up to 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] ,
 * [-3,-1,2,-2,4].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: [-1,0,1]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 1
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 1000
 * 
 */

// @lc code=start
class Solution {

    public int[] sumZero(int n) {
        int[] result = new int[n];
        for(int i = 0, j = 1; i < n-1; i += 2, j++) {
            result[i] = j;
            result[i+1] = -1 * j;
        }
        if(n % 2 != 0) {
            result[n-1] = 0;
        }

        return result;
    }

}
// @lc code=end
