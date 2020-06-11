/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (51.58%)
 * Likes:    1444
 * Dislikes: 74
 * Total Accepted:    343.1K
 * Total Submissions: 648.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 *
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 *
 * Output: [3,2,1]
 *
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
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> postOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> isLeftPushed = new Stack<>();
        Stack<Boolean> isRightPushed = new Stack<>();
        stack.push(root);
        pushLeftRight(root, isLeftPushed, isRightPushed);

        while (!stack.empty()) {
            if (!isLeftPushed.peek()) {
                isLeftPushed.pop();
                isLeftPushed.push(true);
                stack.push(stack.peek().left);
                pushLeftRight(stack.peek(), isLeftPushed, isRightPushed);
            } else if (!isRightPushed.peek()) {
                isRightPushed.pop();
                isRightPushed.push(true);
                stack.push(stack.peek().right);
                pushLeftRight(stack.peek(), isLeftPushed, isRightPushed);
            } else {
                postOrder.add(stack.pop().val);
                isLeftPushed.pop();
                isRightPushed.pop();
            }
        }

        return postOrder;
    }

    private void pushLeftRight(TreeNode root, Stack<Boolean> isLeftPushed, Stack<Boolean> isRightPushed) {
        if (root.left != null) {
            isLeftPushed.push(false);
        } else {
            isLeftPushed.push(true);
        }
        if (root.right != null) {
            isRightPushed.push(false);
        } else {
            isRightPushed.push(true);
        }
    }

}
// @lc code=end
