/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (36.81%)
 * Likes:    1222
 * Dislikes: 66
 * Total Accepted:    146.7K
 * Total Submissions: 390.2K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * Output: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * Output: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 
 * Follow up:
 * 
 * 
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public void recoverTree(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        preOrder(root, preOrder);

        int i = 0;
        int j = preOrder.size()-1;
        while (i < preOrder.size()-1 && preOrder.get(i) <= preOrder.get(i+1)) {
            i++;
        }
        while (j > 0 && preOrder.get(j-1) <= preOrder.get(j)) {
            j--;
        }
        int temp = preOrder.get(i);
        preOrder.set(i, preOrder.get(j));
        preOrder.set(j, temp);

        populateTree(root, new LinkedList<>(preOrder));
    }

    private void preOrder(TreeNode root, List<Integer> preOrder) {
        if (root == null) {
            return;
        }
        preOrder(root.left, preOrder);
        preOrder.add(root.val);
        preOrder(root.right, preOrder);
    }

    private void populateTree(TreeNode root, Queue<Integer> preOrder) {
        if (root == null) {
            return;
        }
        populateTree(root.left, preOrder);
        root.val = preOrder.remove();
        populateTree(root.right, preOrder);
    }

}
// @lc code=end
