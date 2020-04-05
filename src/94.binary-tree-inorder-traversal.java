/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (59.97%)
 * Likes:    2618
 * Dislikes: 114
 * Total Accepted:    655.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> inorderTraversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode trav = root;
        boolean isPopped = false;
        while (trav != null) {
            if (!isPopped && trav.left != null) {
                stack.push(trav);
                trav = trav.left;
            }
            else {
                inorderTraversal.add(trav.val);
                if (trav.right != null) {
                    trav = trav.right;
                    isPopped = false;
                }
                else {
                    if (!stack.empty()) {
                        trav = stack.pop();
                        isPopped = true;
                    }
                    else {
                        trav = null;
                    }
                }
            }
        }

        return inorderTraversal;
    }

}
// @lc code=end
