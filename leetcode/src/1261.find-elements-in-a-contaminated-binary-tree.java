/*
 * @lc app=leetcode id=1261 lang=java
 *
 * [1261] Find Elements in a Contaminated Binary Tree
 *
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/
 *
 * algorithms
 * Medium (72.44%)
 * Likes:    92
 * Dislikes: 22
 * Total Accepted:    9.7K
 * Total Submissions: 13.3K
 * Testcase Example:  '["FindElements","find","find"]\r\n[[[-1,null,-1]],[1],[2]]\r'
 *
 * Given a binary tree with the following rules:
 *
 *
 * root.val == 0
 * If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2
 * * x + 1
 * If treeNode.val == x and treeNode.right != null, then treeNode.right.val ==
 * 2 * x + 2
 *
 *
 * Now the binary tree is contaminated, which means all treeNode.val have been
 * changed to -1.
 *
 * You need to first recover the binary tree and then implement the
 * FindElements class:
 *
 *
 * FindElements(TreeNode* root) Initializes the object with a contamined binary
 * tree, you need to recover it first.
 * bool find(int target) Return if the target value exists in the recovered
 * binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input
 * ["FindElements","find","find"]
 * [[[-1,null,-1]],[1],[2]]
 * Output
 * [null,false,true]
 * Explanation
 * FindElements findElements = new FindElements([-1,null,-1]);
 * findElements.find(1); // return False
 * findElements.find(2); // return True
 *
 * Example 2:
 *
 *
 *
 *
 * Input
 * ["FindElements","find","find","find"]
 * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
 * Output
 * [null,true,true,false]
 * Explanation
 * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
 * findElements.find(1); // return True
 * findElements.find(3); // return True
 * findElements.find(5); // return False
 *
 * Example 3:
 *
 *
 *
 *
 * Input
 * ["FindElements","find","find","find","find"]
 * [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
 * Output
 * [null,true,false,false,true]
 * Explanation
 * FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
 * findElements.find(2); // return True
 * findElements.find(3); // return False
 * findElements.find(4); // return False
 * findElements.find(5); // return True
 *
 *
 *
 * Constraints:
 *
 *
 * TreeNode.val == -1
 * The height of the binary tree is less than or equal to 20
 * The total number of nodes is between [1, 10^4]
 * Total calls of find() is between [1, 10^4]
 * 0 <= target <= 10^6
 *
 *
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class FindElements {

    private Set<Integer> nodes;

    public FindElements(TreeNode root) {
        nodes = new HashSet<>();
        fillTree(root, 0);
    }

    private void fillTree(TreeNode root, int node) {
        if (root == null) {
            return;
        }
        nodes.add(node);
        fillTree(root.left, node * 2 + 1);
        fillTree(root.right, node * 2 + 2);
    }

    public boolean find(int target) {
        return nodes.contains(target);
    }

}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
// @lc code=end
