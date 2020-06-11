/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (51.42%)
 * Likes:    2464
 * Dislikes: 64
 * Total Accepted:    542.7K
 * Total Submissions: 1M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 *
 *
 * return its level order traversal as:
 *
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 *
 *
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<TreeNode> levelOrderNodes = new ArrayList<>();
        List<List<Integer>> levelOrderValues = new ArrayList<>();
        levelOrderNodes.add(root);
        levelOrderValues.add(Arrays.asList(root.val));

        while (true) {
            List<TreeNode> tempNodes = new ArrayList<>();
            List<Integer> tempValues = new ArrayList<>();
            for (TreeNode treeNode : levelOrderNodes) {
                if (treeNode.left != null) {
                    tempNodes.add(treeNode.left);
                    tempValues.add(treeNode.left.val);
                }
                if (treeNode.right != null) {
                    tempNodes.add(treeNode.right);
                    tempValues.add(treeNode.right.val);
                }
            }

            if (tempNodes.isEmpty()) {
                break;
            }
            levelOrderNodes = tempNodes;
            levelOrderValues.add(tempValues);
        }

        return levelOrderValues;
    }

}
// @lc code=end
