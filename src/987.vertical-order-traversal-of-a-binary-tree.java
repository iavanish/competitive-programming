/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
 *
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (33.71%)
 * Likes:    370
 * Dislikes: 895
 * Total Accepted:    37K
 * Total Submissions: 107.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the vertical order traversal of its nodes
 * values.
 * 
 * For each node at position (X, Y), its left and right children respectively
 * will be at positions (X-1, Y-1) and (X+1, Y-1).
 * 
 * Running a vertical line from X = -infinity to X = +infinity, whenever the
 * vertical line touches some nodes, we report the values of the nodes in order
 * from top to bottom (decreasing Y coordinates).
 * 
 * If two nodes have the same position, then the value of the node that is
 * reported first is the value that is smaller.
 * 
 * Return an list of non-empty reports in order of X coordinate.  Every report
 * will have a list of values of nodes.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * 
 * Input: [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation: 
 * Without loss of generality, we can assume the root node is at position (0,
 * 0):
 * Then, the node with value 9 occurs at position (-1, -1);
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * The node with value 20 occurs at position (1, -1);
 * The node with value 7 occurs at position (2, -2).
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation: 
 * The node with value 5 and the node with value 6 have the same position
 * according to the given scheme.
 * However, in the report "[1,5,6]", the node value of 5 comes first since 5 is
 * smaller than 6.
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The tree will have between 1 and 1000 nodes.
 * Each node's value will be between 0 and 1000.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private int xStart;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        xStart = Integer.MAX_VALUE;
        traverseTree(root, 0);
        xStart = -xStart;

        List<Report> reports = new ArrayList<>();
        List<Pair> levelOrderNodes = Arrays.asList(new Pair(root, xStart));
        int y = 0;
        while (!levelOrderNodes.isEmpty()) {
            List<Pair> temp = new ArrayList<>();
            for (Pair pair : levelOrderNodes) {
                reports.add(new Report(pair.index, y, pair.node.val));
                if (pair.node.left != null) {
                    temp.add(new Pair(pair.node.left, pair.index-1));
                }
                if (pair.node.right != null) {
                    temp.add(new Pair(pair.node.right, pair.index+1));
                }
            }
            levelOrderNodes = temp;
            y++;
        }

        reports.sort((r1, r2) -> {
            if (r1.x != r2.x) {
                return r1.x - r2.x;
            }
            else if (r1.y != r2.y) {
                return r1.y - r2.y;
            }
            return r1.val - r2.val;
        });

        return reports
                .stream()
                .collect(Collectors.groupingBy(Report::getX))
                .entrySet()
                .stream()
                .map(entry -> entry.getValue()
                        .stream()
                        .map(Report::getVal)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private void traverseTree(TreeNode root, int currX) {
        if (root == null) {
            return;
        }
        xStart = Math.min(xStart, currX);
        traverseTree(root.left, currX-1);
        traverseTree(root.right, currX+1);
    }

    private static class Pair {
        public TreeNode node;
        public int index;
        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    private static class Report {
        public int x;
        public int y;
        public int val;
        public Report(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        public int getX() {
            return x;
        }
        public int getVal() {
            return val;
        }
    }

}
// @lc code=end
