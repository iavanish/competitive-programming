/*
 * @lc app=leetcode id=1443 lang=java
 *
 * [1443] Minimum Time to Collect All Apples in a Tree
 *
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
 *
 * algorithms
 * Medium (52.25%)
 * Likes:    8
 * Dislikes: 0
 * Total Accepted:    2.8K
 * Total Submissions: 5.4K
 * Testcase Example:  '7\n' +
  '[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]\n' +
  '[false,false,true,false,true,true,false]'
 *
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1,
 * which has some apples in their vertices. You spend 1 second to walk over one
 * edge of the tree. Return the minimum time in seconds you have to spend in
 * order to collect all apples in the tree starting at vertex 0 and coming back
 * to this vertex.
 * 
 * The edges of the undirected tree are given in the array edges, where
 * edges[i] = [fromi, toi] means that exists an edge connecting the vertices
 * fromi and toi. Additionally, there is a boolean array hasApple, where
 * hasApple[i] = true means that vertex i has an apple, otherwise, it does not
 * have any apple.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,true,false,true,true,false]
 * Output: 8 
 * Explanation: The figure above represents the given tree where red vertices
 * have an apple. One optimal path to collect all apples is shown by the green
 * arrows.  
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,true,false,false,true,false]
 * Output: 6
 * Explanation: The figure above represents the given tree where red vertices
 * have an apple. One optimal path to collect all apples is shown by the green
 * arrows.  
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple =
 * [false,false,false,false,false,false,false]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * edges.length == n-1
 * edges[i].length == 2
 * 0 <= fromi, toi <= n-1
 * fromi < toi
 * hasApple.length == n
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjList = new ArrayList<>();
        List<Boolean> subTreeHasApple = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            subTreeHasApple.add(false);
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        populateApple(adjList, 0, new boolean[n], hasApple, subTreeHasApple);
        return traverse(adjList, 0, new boolean[n], subTreeHasApple);
    }

    private int traverse(List<List<Integer>> adjList, int currNode, boolean[] isVisited, List<Boolean> subTreeHasApple) {
        isVisited[currNode] = true;
        int count = 0;
        for (Integer neighbour : adjList.get(currNode)) {
            if (!isVisited[neighbour] && subTreeHasApple.get(neighbour)) {
                count += (2 + traverse(adjList, neighbour, isVisited, subTreeHasApple));
            }
        }
        return count;
    }

    private int populateApple(List<List<Integer>> adjList, int currNode, boolean[] isVisited, List<Boolean> hasApple, List<Boolean> subTreeHasApple) {
        isVisited[currNode] = true;
        int apples = hasApple.get(currNode) ? 1 : 0;
        for (Integer neighbour : adjList.get(currNode)) {
            if (!isVisited[neighbour]) {
                apples += populateApple(adjList, neighbour, isVisited, hasApple, subTreeHasApple);
            }
        }
        if (apples > 0) {
            subTreeHasApple.set(currNode, true);
        }
        return apples;
    }

}
// @lc code=end
