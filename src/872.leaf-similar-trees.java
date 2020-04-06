/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
 *
 * https://leetcode.com/problems/leaf-similar-trees/description/
 *
 * algorithms
 * Easy (64.48%)
 * Likes:    599
 * Dislikes: 31
 * Total Accepted:    74.3K
 * Total Submissions: 114.7K
 * Testcase Example:  '[3,5,1,6,2,9,8,null,null,7,4]\n' +
  '[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]'
 *
 * Consider all the leaves of a binary tree.  From left to right order, the
 * values of those leaves form a leaf value sequence.
 * 
 * 
 * 
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4,
 * 9, 8).
 * 
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 * 
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 * 
 * 
 * Constraints:
 * 
 * 
 * Both of the given trees will have between 1 and 200 nodes.
 * Both of the given trees will have values between 0 and 200
 * 
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

    private TreeNode leafList;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        else if (root1 == null ^ root2 == null) {
            return false;
        }

        TreeNode leaves1, tempLeaves1, leaves2, tempLeaves2;
        leafList = new TreeNode(0);
        leaves1 = tempLeaves1 = leafList;
        linkLeaves(root1);
        leafList = new TreeNode(0);
        leaves2 = tempLeaves2 = leafList;
        linkLeaves(root2);

        while (leaves1 != null && leaves2 != null) {
            if (leaves1.val != leaves2.val) {
                break;
            }
            leaves1 = leaves1.right;
            leaves2 = leaves2.right;
        }

        releaseLeaves(tempLeaves1);
        releaseLeaves(tempLeaves2);

        return leaves1 == null && leaves2 == null;
    }

    private void releaseLeaves(TreeNode leaves) {
        while (leaves != null) {
            TreeNode temp = leaves.right;
            leaves.right = null;
            leaves = temp;
        }
    }

    private void linkLeaves(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafList.right = root;
            leafList = root;
        }
        linkLeaves(root.left);
        linkLeaves(root.right);
    }

}
// @lc code=end
