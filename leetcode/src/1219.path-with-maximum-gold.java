/*
 * @lc app=leetcode id=1219 lang=java
 *
 * [1219] Path with Maximum Gold
 *
 * https://leetcode.com/problems/path-with-maximum-gold/description/
 *
 * algorithms
 * Medium (64.49%)
 * Likes:    434
 * Dislikes: 19
 * Total Accepted:    26.6K
 * Total Submissions: 41.2K
 * Testcase Example:  '[[0,6,0],[5,8,7],[0,9,0]]'
 *
 * In a gold mine grid of size m * n, each cell in this mine has an integer
 * representing the amount of gold in that cell, 0 if it is empty.
 *
 * Return the maximum amount of gold you can collect under the
 * conditions:
 *
 *
 * Every time you are located in a cell you will collect all the gold in that
 * cell.
 * From your position you can walk one step to the left, right, up or down.
 * You can't visit the same cell more than once.
 * Never visit a cell with 0 gold.
 * You can start and stop collecting gold from any position in the grid that
 * has some gold.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 * ⁠[5,8,7],
 * ⁠[0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * Output: 28
 * Explanation:
 * [[1,0,7],
 * ⁠[2,0,6],
 * ⁠[3,4,5],
 * ⁠[0,3,0],
 * ⁠[9,0,20]]
 * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= grid.length, grid[i].length <= 15
 * 0 <= grid[i][j] <= 100
 * There are at most 25 cells containing gold.
 *
 */

// @lc code=start
class Solution {

    private final int[] nextI = {-1, 0, 0, 1};
    private final int[] nextJ = {0, -1, 1, 0};

    public int getMaximumGold(int[][] grid) {
        int gold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    gold = Math.max(gold, getMaximumGold(grid, i, j, new boolean[grid.length][grid[0].length]));
                }
            }
        }
        return gold;
    }

    private int getMaximumGold(int[][] grid, int i, int j, boolean[][] isVisited) {
        if (grid[i][j] == 0) {
            return 0;
        }
        int gold = 0;
        isVisited[i][j] = true;
        for (int x = 0; x < 4; x++) {
            int nextI = i + this.nextI[x];
            int nextJ = j + this.nextJ[x];
            if (visitable(grid, nextI, nextJ, isVisited)) {
                gold = Math.max(gold, getMaximumGold(grid, nextI, nextJ, isVisited));
            }
        }
        isVisited[i][j] = false;
        return gold + grid[i][j];
    }

    private boolean visitable(int[][] grid, int nextI, int nextJ, boolean[][] isVisited) {
        return nextI >= 0 && nextI < grid.length && nextJ >= 0 && nextJ < grid[0].length && !isVisited[nextI][nextJ];
    }

}
// @lc code=end
