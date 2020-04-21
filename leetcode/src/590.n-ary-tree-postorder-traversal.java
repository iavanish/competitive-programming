/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (69.68%)
 * Likes:    515
 * Dislikes: 57
 * Total Accepted:    76.6K
 * Total Submissions: 108.3K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * 
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * 
 * 
 * 
 * Follow up:
 * 
 * Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [5,6,3,2,4,1]
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Solution {

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> postorder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Set<Node> seen = new HashSet<>();
        stack.push(root);
        seen.add(root);
        while (!stack.empty()) {
            if (stack.peek().children == null || stack.peek().children.isEmpty() || seen.contains(stack.peek().children.get(0))) {
                postorder.add(stack.pop().val);
            }
            else {
                Node node = stack.peek();
                for (int i = node.children.size()-1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                    seen.add(node.children.get(i));
                }
            }
        }

        return postorder;
    }

}
// @lc code=end
