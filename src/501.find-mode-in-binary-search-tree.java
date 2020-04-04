/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (40.75%)
 * Likes:    763
 * Dislikes: 295
 * Total Accepted:    76.5K
 * Total Submissions: 185.2K
 * Testcase Example:  '[1,null,2,2]'
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * For example:
 * Given BST [1,null,2,2],
 * 
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 
 * 
 * return [2].
 * 
 * Note: If a tree has more than one mode, you can return them in any order.
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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

    private int modeCount = 0;
    private List<Integer> modeValue = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        modeCount = 0;
        traverseTree(root);
        int[] result = new int[modeValue.size()];
        for (int i = 0; i < modeValue.size(); i++) {
            result[i] = modeValue.get(i);
        }
        return result;
    }

    private void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        int countNodes = 1 + countNodes(root.left, root.val) + countNodes(root.right, root.val);
        if (countNodes == modeCount) {
            modeValue.add(root.val);
        }
        if (countNodes > modeCount) {
            modeCount = countNodes;
            modeValue = new ArrayList<>();
            modeValue.add(root.val);
        }
        traverseTree(root.left);
        traverseTree(root.right);
    }

    private int countNodes(TreeNode root, int value) {
        if (root == null) {
            return 0;
        }
        if (root.val < value) {
            return countNodes(root.right, value);
        }
        if (root.val > value) {
            return countNodes(root.left, value);
        }
        return 1 + countNodes(root.left, value) + countNodes(root.right, value);
    }

}
// @lc code=end
