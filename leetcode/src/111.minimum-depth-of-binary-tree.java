/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (36.33%)
 * Likes:    1122
 * Dislikes: 609
 * Total Accepted:    379.2K
 * Total Submissions: 1M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 * return its minimum depth = 2.
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

    private int minDepth;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDepth = Integer.MAX_VALUE;
        traverse(root, 1);
        return minDepth;
    }

    private void traverse(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, currDepth);
        }
        traverse(root.left, currDepth + 1);
        traverse(root.right, currDepth + 1);
    }

}
// @lc code=end
