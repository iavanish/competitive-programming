/*
 * @lc app=leetcode id=814 lang=java
 *
 * [814] Binary Tree Pruning
 *
 * https://leetcode.com/problems/binary-tree-pruning/description/
 *
 * algorithms
 * Medium (72.60%)
 * Likes:    855
 * Dislikes: 33
 * Total Accepted:    56.3K
 * Total Submissions: 76.5K
 * Testcase Example:  '[1,null,0,0,1]'
 *
 * We are given the head node root of a binary tree, where additionally every
 * node's value is either a 0 or a 1.
 *
 * Return the same tree where every subtree (of the given tree) not containing
 * a 1 has been removed.
 *
 * (Recall that the subtree of a node X is X, plus every node that is a
 * descendant of X.)
 *
 *
 * Example 1:
 * Input: [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 * ⁠
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 *
 *
 *
 *
 *
 * Example 2:
 * Input: [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 *
 *
 *
 *
 *
 *
 * Example 3:
 * Input: [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * The binary tree will have at most 100 nodes.
 * The value of each node will only be 0 or 1.
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

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        if (root.val + leftSum + rightSum == 0) {
            return null;
        }
        if (leftSum == 0) {
            root.left = null;
        }
        if (rightSum == 0) {
            root.right = null;
        }
        return root;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        if (leftSum == 0) {
            root.left = null;
        }
        if (rightSum == 0) {
            root.right = null;
        }
        return root.val + leftSum + rightSum;
    }

}
// @lc code=end
