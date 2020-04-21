/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (52.01%)
 * Likes:    698
 * Dislikes: 58
 * Total Accepted:    78.2K
 * Total Submissions: 149.2K
 * Testcase Example:  '[1,null,3,2]'
 *
 * Given a binary search tree with non-negative values, find the minimum
 * absolute difference between values of any two nodes.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and
 * 1 (or between 2 and 3).
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * There are at least two nodes in this BST.
 * This question is the same as 783:
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public int getMinimumDifference(TreeNode root) {
        return (int) traverseTree(root).minDifference;
    }

    private NodeInfo traverseTree(TreeNode root) {
        if (root == null) {
            return new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        NodeInfo leftNodeInfo = traverseTree(root.left);
        NodeInfo rightNodeInfo = traverseTree(root.right);
        long min = Math.min(root.val, Math.min(leftNodeInfo.min, rightNodeInfo.min));
        long max = Math.max(root.val, Math.max(leftNodeInfo.max, rightNodeInfo.max));
        return new NodeInfo(min, max,
                Math.min(leftNodeInfo.minDifference,
                        Math.min(rightNodeInfo.minDifference,
                                Math.min(
                                        Math.abs(root.val - leftNodeInfo.max),
                                        Math.abs(rightNodeInfo.min - root.val)))));
    }

    private static class NodeInfo {
        public long min;
        public long max;
        public long minDifference;
        public NodeInfo(long min, long max, long minDifference) {
            this.min = min;
            this.max = max;
            this.minDifference = minDifference;
        }
    }

}
// @lc code=end
