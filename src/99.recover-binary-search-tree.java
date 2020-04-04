/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (36.81%)
 * Likes:    1222
 * Dislikes: 66
 * Total Accepted:    146.7K
 * Total Submissions: 390.2K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 *
 * Input: [1,3,null,null,2]
 *
 * 1
 * /
 * 3
 * \
 * 2
 *
 * Output: [3,1,null,null,2]
 *
 * 3
 * /
 * 1
 * \
 * 2
 *
 *
 * Example 2:
 *
 *
 * Input: [3,1,4,null,null,2]
 *
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 *
 * Output: [2,1,4,null,null,3]
 *
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 *
 *
 * Follow up:
 *
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
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

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode maxLeft = maxNode(root.left);
        TreeNode minRight = minNode(root.right);

        if (maxLeft != null && minRight != null && maxLeft.val > root.val && minRight.val < root.val) {
            swap(maxLeft, minRight);
        }
        else if (maxLeft != null && maxLeft.val > root.val) {
            swap(maxLeft, root);
        }
        else if (minRight != null && minRight.val < root.val) {
            swap(minRight, root);
        }
        else {
            recoverTree(root.left);
            recoverTree(root.right);
        }
    }

    private TreeNode minNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode minLeft = minNode(root.left);
        TreeNode minRight = minNode(root.right);
        if (minLeft != null && minRight != null) {
            if (minLeft.val < root.val && minLeft.val < minRight.val) {
                return minLeft;
            }
            if (minRight.val < root.val && minRight.val < root.val) {
                return minRight;
            }
            return root;
        }
        if (minLeft != null && minLeft.val < root.val) {
            return minLeft;
        }
        if (minRight != null && minRight.val < root.val) {
            return minRight;
        }
        return root;
    }

    private TreeNode maxNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode minLeft = maxNode(root.left);
        TreeNode minRight = maxNode(root.right);
        if (minLeft != null && minRight != null) {
            if (minLeft.val > root.val && minLeft.val > minRight.val) {
                return minLeft;
            }
            if (minRight.val > root.val && minRight.val > root.val) {
                return minRight;
            }
            return root;
        }
        if (minLeft != null && minLeft.val > root.val) {
            return minLeft;
        }
        if (minRight != null && minRight.val > root.val) {
            return minRight;
        }
        return root;
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

}
// @lc code=end
