/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (49.32%)
 * Likes:    1094
 * Dislikes: 200
 * Total Accepted:    287.4K
 * Total Submissions: 569.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
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
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        Collections.reverse(levelOrderValues);
        return levelOrderValues;
    }

}
// @lc code=end
