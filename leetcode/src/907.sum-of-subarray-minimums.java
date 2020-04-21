/*
 * @lc app=leetcode id=907 lang=java
 *
 * [907] Sum of Subarray Minimums
 *
 * https://leetcode.com/problems/sum-of-subarray-minimums/description/
 *
 * algorithms
 * Medium (30.00%)
 * Likes:    905
 * Dislikes: 61
 * Total Accepted:    20.5K
 * Total Submissions: 66.4K
 * Testcase Example:  '[3,1,2,4]'
 *
 * Given an array of integers A, find the sum of min(B), where B ranges over
 * every (contiguous) subarray of A.
 * 
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2],
 * [1,2,4], [3,1,2,4]. 
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 * 
 * 
 * 
 * 
 * 
 * 
 */

import java.util.Stack;

// @lc code=start
class Solution {

    public int sumSubarrayMins(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }

        int[] leftSpan = new int[n];
        int[] rightSpan = new int[n];
        Stack<Integer> spanIndex = new Stack<>();
        Stack<Integer> spanCount = new Stack<>();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!spanIndex.isEmpty() && A[spanIndex.peek()] >= A[i]) {
                leftSpan[spanIndex.pop()] = spanCount.peek();
                count += spanCount.pop();
            }
            spanIndex.push(i);
            spanCount.push(count);
        }
        while (!spanIndex.isEmpty()) {
            leftSpan[spanIndex.pop()] = spanCount.pop();
        }

        for (int i = n-1; i >= 0; i--) {
            int count = 1;
            while (!spanIndex.isEmpty() && A[spanIndex.peek()] > A[i]) {
                rightSpan[spanIndex.pop()] += spanCount.peek();
                count += spanCount.pop();
            }
            spanIndex.push(i);
            spanCount.push(count);
        }
        while (!spanIndex.isEmpty()) {
            rightSpan[spanIndex.pop()] += spanCount.pop();
        }

        int sumSubarrayMins = 0;
        for (int i = 0; i < n; i++) {
            sumSubarrayMins += (A[i] * ((leftSpan[i] + rightSpan[i] - 1 + (leftSpan[i]-1) * (rightSpan[i]-1))) % 1000000007);
            sumSubarrayMins %= 1000000007;
        }
        return sumSubarrayMins;
    }

    private int summation(int n) {
        return (n * (n+1)) / 2;
    }

}
// @lc code=end
