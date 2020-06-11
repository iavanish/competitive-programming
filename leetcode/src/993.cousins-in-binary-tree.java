/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
 *
 * https://leetcode.com/problems/cousins-in-binary-tree/description/
 *
 * algorithms
 * Easy (52.25%)
 * Likes:    724
 * Dislikes: 43
 * Total Accepted:    90.2K
 * Total Submissions: 172.3K
 * Testcase Example:  '[1,2,3,4]\n4\n3'
 *
 * In a binary tree, the root node is at depth 0, and children of each depth k
 * node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have
 * different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x
 * and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are
 * cousins.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 *
 *
 *
 * Example 2:
 *
 *
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 *
 *
 *
 * Example 3:
 *
 *
 *
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 *
 *
 *
 *
 *
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
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        NodeData xNodeData = findNodeData(root, x, -1, 0);
        NodeData yNodeData = findNodeData(root, y, -1, 0);

        return xNodeData != null && yNodeData != null && xNodeData.level == yNodeData.level && xNodeData.parent != yNodeData.parent;
    }

    private NodeData findNodeData(TreeNode root, int key, int parent, int depth) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            return new NodeData(parent, depth);
        }
        NodeData temp = findNodeData(root.left, key, root.val, depth + 1);
        if (temp != null) {
            return temp;
        }
        return findNodeData(root.right, key, root.val, depth + 1);
    }

    private static class NodeData {

        public int parent;
        public int level;

        public NodeData(int parent, int level) {
            this.parent = parent;
            this.level = level;
        }

    }

}
// @lc code=end
