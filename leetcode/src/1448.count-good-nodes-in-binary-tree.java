/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
 *
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 *
 * algorithms
 * Medium (65.18%)
 * Likes:    32
 * Dislikes: 0
 * Total Accepted:    4.3K
 * Total Submissions: 6.5K
 * Testcase Example:  '[3,1,4,3,null,1,5]'
 *
 * Given a binary tree root, a node X in the tree is named good if in the path
 * from root to X there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 *
 * Example 2:
 *
 *
 *
 *
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than
 * it.
 *
 * Example 3:
 *
 *
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 *
 *
 * Constraints:
 *
 *
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
 *
 */

// @lc code=start

import java.util.SortedMap;
import java.util.TreeMap;

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

    public int goodNodes(TreeNode root) {
        return goodNodes(root, new TreeMap<>());
    }

    private int goodNodes(TreeNode root, SortedMap<Integer, Integer> sortedPath) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        if (sortedPath.isEmpty() || sortedPath.lastKey() <= root.val) {
            max++;
        }
        int count = sortedPath.getOrDefault(root.val, 0);
        sortedPath.put(root.val, count + 1);
        max += (goodNodes(root.left, sortedPath) + goodNodes(root.right, sortedPath));
        if (count == 0) {
            sortedPath.remove(root.val);
        } else {
            sortedPath.put(root.val, count);
        }
        return max;
    }

}
// @lc code=end
