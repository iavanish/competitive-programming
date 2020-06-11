/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (43.54%)
 * Likes:    1438
 * Dislikes: 50
 * Total Accepted:    302.5K
 * Total Submissions: 675.3K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 *
 *
 * Return:
 *
 *
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
 *
 *
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> pathSum = new ArrayList<>();
        pathSum(root, sum, pathSum, new LinkedList<>());
        return pathSum;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> pathSum, Deque<Integer> currentSum) {
        if (root == null) {
        } else if (root.left == null && root.right == null) {
            if (root.val == sum) {
                currentSum.addLast(root.val);
                pathSum.add(new ArrayList<>(currentSum));
                currentSum.removeLast();
            }
        } else {
            currentSum.addLast(root.val);
            pathSum(root.left, sum - root.val, pathSum, currentSum);
            pathSum(root.right, sum - root.val, pathSum, currentSum);
            currentSum.removeLast();
        }
    }

}
// @lc code=end
