/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
 *
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (43.39%)
 * Likes:    1925
 * Dislikes: 92
 * Total Accepted:    187K
 * Total Submissions: 426.9K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 *
 *
 * Example 1:
 *
 * Given tree s:
 *
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 *
 * Given tree t:
 *
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 *
 * Return true, because t has the same structure and node values with a subtree
 * of s.
 *
 *
 * Example 2:
 *
 * Given tree s:
 *
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 *
 * Given tree t:
 *
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 *
 * Return false.
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

    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder sPreOrder = new StringBuilder();
        StringBuilder tPreOrder = new StringBuilder();
        preOrder(s, sPreOrder);
        preOrder(t, tPreOrder);
        return sPreOrder.toString().contains(tPreOrder.toString());
    }

    private void preOrder(TreeNode root, StringBuilder preOrder) {
        if (root == null) {
            preOrder.append("null");
        } else {
            preOrder.append("#" + root.val);
            preOrder(root.left, preOrder);
            preOrder(root.right, preOrder);
        }
    }

}
// @lc code=end
