/*
 * @lc app=leetcode id=1425 lang=java
 *
 * [1425] Constrained Subset Sum
 *
 * https://leetcode.com/problems/constrained-subset-sum/description/
 *
 * algorithms
 * Hard (27.73%)
 * Likes:    6
 * Dislikes: 2
 * Total Accepted:    900
 * Total Submissions: 3.3K
 * Testcase Example:  '[10,2,-10,5,20]\n2'
 *
 * Given an integer array nums and an integer k, return the maximum sum of a
 * non-empty subset of that array such that for every two consecutive integers
 * in the subset, nums[i] and nums[j], where i < j, the condition j - i <= k is
 * satisfied.
 *
 * A subset of an array is obtained by deleting some number of elements (can be
 * zero) from the array, leaving the remaining elements in their original
 * order.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [10,2,-10,5,20], k = 2
 * Output: 37
 * Explanation: The subset is [10, 2, 5, 20].
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [-1,-2,-3], k = 1
 * Output: -1
 * Explanation: The subset must be non-empty, so we choose the largest
 * number.
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [10,-2,-10,-5,20], k = 2
 * Output: 23
 * Explanation: The subset is [10, -2, -5, 20].
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 *
 */

// @lc code=start
class Solution {

    private int[] segmentTree;
    private int n;

    public int constrainedSubsetSum(int[] nums, int k) {
        n = nums.length;
        segmentTree = new int[4 * n];

        int[] dp = new int[n];
        dp[0] = nums[0];
        update(0, dp[0]);

        for (int i = 1; i < n; i++) {
            int max = Math.max(0, maxRange(Math.max(0, i - k), i - 1));
            dp[i] = nums[i] + max;
            update(i, dp[i]);
        }

        int maxConstrainedSubsetSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxConstrainedSubsetSum = Math.max(maxConstrainedSubsetSum, dp[i]);
        }

        return maxConstrainedSubsetSum;
    }

    private void update(int i, int val) {
        updateTree(segmentTree, 0, 0, n - 1, i, val);
    }

    private int maxRange(int i, int j) {
        return queryTree(segmentTree, 0, 0, n - 1, i, j);
    }

    private void updateTree(int[] segmentTree, int node, int left, int right, int index, int value) {
        if (left == right && left == index) {
            segmentTree[node] = value;
        } else if (left <= index && index <= right) {
            int middle = middle(left, right);
            updateTree(segmentTree, node * 2 + 1, left, middle, index, value);
            updateTree(segmentTree, node * 2 + 2, middle + 1, right, index, value);
            segmentTree[node] = Math.max(segmentTree[node * 2 + 1], segmentTree[node * 2 + 2]);
        }
    }

    private int queryTree(int[] segmentTree, int node, int left, int right, int queryI, int queryJ) {
        if (right < left || queryJ < left || right < queryI) {
            return 0;
        } else if (queryI <= left && right <= queryJ) {
            return segmentTree[node];
        }
        int middle = middle(left, right);
        return Math.max(queryTree(segmentTree, node * 2 + 1, left, middle, queryI, queryJ),
                queryTree(segmentTree, node * 2 + 2, middle + 1, right, queryI, queryJ));
    }

    private int middle(int left, int right) {
        return left + (right - left) / 2;
    }

}
// @lc code=end
