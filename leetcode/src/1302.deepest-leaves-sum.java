/*
 * @lc app=leetcode id=1302 lang=java
 *
 * [1302] Deepest Leaves Sum
 *
 * https://leetcode.com/problems/deepest-leaves-sum/description/
 *
 * algorithms
 * Medium (86.79%)
 * Likes:    118
 * Dislikes: 14
 * Total Accepted:    10.9K
 * Total Submissions: 12.9K
 * Testcase Example:  '[1,2,3,4,5,null,6,7,null,null,null,null,8]'
 *
 * Given a binary tree, return the sum of values of its deepest leaves.
 *
 * Example 1:
 *
 *
 *
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 *
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
 *
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private int maxDepth = 0;
    private int maxDepthSum = 0;

    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root, 0);
        return maxDepthSum;
    }

    private void deepestLeavesSum(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }
        if (currDepth == maxDepth) {
            maxDepthSum += root.val;
        }
        if (currDepth > maxDepth) {
            maxDepth = currDepth;
            maxDepthSum = root.val;
        }
        deepestLeavesSum(root.left, currDepth + 1);
        deepestLeavesSum(root.right, currDepth + 1);
    }

}
// @lc code=end
