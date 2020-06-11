/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 *
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 *
 * algorithms
 * Medium (72.71%)
 * Likes:    570
 * Dislikes: 47
 * Total Accepted:    42.5K
 * Total Submissions: 58.3K
 * Testcase Example:  '[[1,2],[3],[3],[]]'
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from
 * node 0 to node N-1, and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
 * graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 *
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 *
 * Note:
 *
 *
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of
 * nodes inside one path.
 *
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        allPathsSourceTarget(graph, 0, allPaths, new ArrayList<>());
        return allPaths;
    }

    private void allPathsSourceTarget(int[][] graph, int currNode, List<List<Integer>> allPaths, List<Integer> currentPath) {
        currentPath.add(currNode);
        if (currNode == graph.length - 1) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (int i = 0; i < graph[currNode].length; i++) {
                allPathsSourceTarget(graph, graph[currNode][i], allPaths, currentPath);
            }
        }
        currentPath.remove(currentPath.size() - 1);
    }

}
// @lc code=end
