/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 * algorithms
 * Medium (41.28%)
 * Likes:    1449
 * Dislikes: 75
 * Total Accepted:    97.3K
 * Total Submissions: 231.6K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n3'
 *
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 *
 *
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 * ⁠   5
 * ⁠  / \
 * ⁠ 4   6
 * ⁠/     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 * ⁠   5
 * ⁠  / \
 * ⁠ 2   6
 * ⁠  \   \
 * ⁠   4   7
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

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode keyNode = findNode(root, key);
        if (keyNode == null) {
            return root;
        }
        TreeNode successor = findSuccessor(keyNode.right);
        if (successor == null) {
            if (keyNode == root) {
                return root.left;
            }
            TreeNode keyNodeParent = findParent(root, keyNode);
            if (keyNodeParent.left == keyNode) {
                keyNodeParent.left = keyNode.left;
            } else {
                keyNodeParent.right = keyNode.left;
            }
        } else {
            TreeNode successorParent = findParent(root, successor);
            keyNode.val = successor.val;
            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }
        return root;
    }

    private TreeNode findParent(TreeNode root, TreeNode node) {
        if (root == null || root.left == node || root.right == node) {
            return root;
        } else if (root.val < node.val) {
            return findParent(root.right, node);
        }
        return findParent(root.left, node);
    }

    private TreeNode findSuccessor(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        return findSuccessor(root.left);
    }

    private TreeNode findNode(TreeNode root, int key) {
        if (root == null || root.val == key) {
            return root;
        } else if (root.val < key) {
            return findNode(root.right, key);
        }
        return findNode(root.left, key);
    }

}
// @lc code=end
