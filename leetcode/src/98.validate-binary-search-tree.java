/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (26.83%)
 * Likes:    3163
 * Dislikes: 451
 * Total Accepted:    592.1K
 * Total Submissions: 2.2M
 * Testcase Example:  '[2,1,3]'
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 *
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
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

    public boolean isValidBST(TreeNode root) {
        return validateBST(root).isBST;
    }

    private NodeInfo validateBST(TreeNode root) {
        if (root == null) {
            return new NodeInfo(Long.MAX_VALUE, Long.MIN_VALUE, true);
        }
        NodeInfo leftNodeInfo = validateBST(root.left);
        NodeInfo rightNodeInfo = validateBST(root.right);
        long min = Math.min(root.val, Math.min(leftNodeInfo.min, rightNodeInfo.min));
        long max = Math.max(root.val, Math.max(leftNodeInfo.max, rightNodeInfo.max));
        if (!leftNodeInfo.isBST || !rightNodeInfo.isBST || root.val <= leftNodeInfo.max || rightNodeInfo.min <= root.val) {
            return new NodeInfo(min, max, false);
        }
        return new NodeInfo(min, max, true);
    }

    private static class NodeInfo {

        public long min;
        public long max;
        public boolean isBST;

        public NodeInfo(long min, long max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }

    }

}
// @lc code=end
