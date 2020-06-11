/*
 * @lc app=leetcode id=1305 lang=java
 *
 * [1305] All Elements in Two Binary Search Trees
 *
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/
 *
 * algorithms
 * Medium (77.00%)
 * Likes:    134
 * Dislikes: 3
 * Total Accepted:    11.4K
 * Total Submissions: 15.2K
 * Testcase Example:  '[2,1,4]\r\n[1,0,3]\r'
 *
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in
 * ascending order.
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 *
 *
 * Example 2:
 *
 *
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 *
 *
 * Example 3:
 *
 *
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 *
 *
 * Example 4:
 *
 *
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 *
 *
 * Example 5:
 *
 *
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 *
 *
 *
 * Constraints:
 *
 *
 * Each tree has at most 5000 nodes.
 * Each node's value is between [-10^5, 10^5].
 *
 *
 */

// @lc code=start

import java.util.ArrayList;
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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nodes1 = new ArrayList<>();
        List<Integer> nodes2 = new ArrayList<>();
        getAllElements(root1, nodes1);
        getAllElements(root2, nodes2);

        List<Integer> nodes = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nodes1.size() && j < nodes2.size()) {
            if (nodes1.get(i) < nodes2.get(j)) {
                nodes.add(nodes1.get(i++));
            } else {
                nodes.add(nodes2.get(j++));
            }
        }
        nodes.addAll(nodes1.subList(i, nodes1.size()));
        nodes.addAll(nodes2.subList(j, nodes2.size()));

        return nodes;
    }

    private void getAllElements(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        getAllElements(root.left, nodes);
        nodes.add(root.val);
        getAllElements(root.right, nodes);
    }

}
// @lc code=end
