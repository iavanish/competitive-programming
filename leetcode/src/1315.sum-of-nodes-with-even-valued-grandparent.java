/*
 * @lc app=leetcode id=1315 lang=java
 *
 * [1315] Sum of Nodes with Even-Valued Grandparent
 *
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
 *
 * algorithms
 * Medium (84.2%)
 * Likes:    96
 * Dislikes: 5
 * Total Accepted:    7.0K
 * Total Submissions: 8.3K
 * Testcase Example:  '[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]'
 *
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.
 * (A grandparent of a node is the parent of its parent, if it exists.)
 * If there are no nodes with an even-valued grandparent, return 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
 *
 *
 *
 *
 * Constraints:
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
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
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private int sum;

    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        sumEvenGrandparent(root, 1, 1);
        return sum;
    }

    private void sumEvenGrandparent(TreeNode root, int parent, int grandParent) {
        if (root == null) {
            return;
        }
        if (grandParent % 2 == 0) {
            sum += root.val;
        }
        sumEvenGrandparent(root.left, root.val, parent);
        sumEvenGrandparent(root.right, root.val, parent);
    }

}
// @lc code=end
