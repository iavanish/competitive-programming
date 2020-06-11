/*
 * @lc app=leetcode id=1254 lang=java
 *
 * [1254] Number of Closed Islands
 *
 * https://leetcode.com/problems/number-of-closed-islands/description/
 *
 * algorithms
 * Medium (59.79%)
 * Likes:    317
 * Dislikes: 15
 * Total Accepted:    15.9K
 * Total Submissions: 26.6K
 * Testcase Example:  '[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]'
 *
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a
 * maximal 4-directionally connected group of 0s and a closed island is an
 * island totally (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input: grid =
 * [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water
 * (group of 1s).
 *
 * Example 2:
 *
 *
 *
 *
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 *
 *
 * Example 3:
 *
 *
 * Input: grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * ⁠              [1,1,1,1,1,1,1]]
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 *
 */

// @lc code=start
class Solution {

    private final int[] nextI = {-1, 0, 0, 1};
    private final int[] nextJ = {0, -1, 1, 0};

    public int closedIsland(int[][] grid) {
        int closedIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (!notClosedIsland(grid, i, j)) {
                        closedIslands++;
                    }
                }
            }
        }

        return closedIslands;
    }

    private boolean notClosedIsland(int[][] grid, int i, int j) {
        boolean notClosedIsland = (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1);
        grid[i][j] = -1;
        for (int x = 0; x < 4; x++) {
            int nextI = i + this.nextI[x];
            int nextJ = j + this.nextJ[x];
            if (visitable(grid, nextI, nextJ)) {
                notClosedIsland = notClosedIsland(grid, nextI, nextJ) || notClosedIsland;
            }
        }
        return notClosedIsland;
    }

    private boolean visitable(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0;
    }

}
// @lc code=end
