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

    private Integer prevVal = null;
    private int currCount = 0;
    private int modeCount = 0;
    private int modes = 0;
    private int[] modeValues;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        inOrder(root);
        if (currCount == modeCount) {
            modes++;
        }
        else if (modeCount < currCount) {
            modeCount = currCount;
            modes = 1;
        }
        modeValues = new int[modes];
        prevVal = null;
        currCount = 0;
        modes = 0;
        inOrder(root);
        if (currCount == modeCount) {
            if (modeValues != null) {
                modeValues[modes] = prevVal;
            }
            modes++;
        }
        return modeValues;
    }

    private void processNode(TreeNode node) {
        if (prevVal == null) {
            prevVal = node.val;
            currCount = 1;
        }
        else if (prevVal != node.val) {
            if (currCount == modeCount) {
                if (modeValues != null) {
                    modeValues[modes] = prevVal;
                }
                modes++;
            }
            else if (modeCount < currCount) {
                modeCount = currCount;
                modes = 1;
            }
            prevVal = node.val;
            currCount = 1;
        }
        else {
            currCount++;
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        processNode(root);
        inOrder(root.right);
    }

}
// @lc code=end
