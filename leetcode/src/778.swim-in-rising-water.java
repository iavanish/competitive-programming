/*
 * @lc app=leetcode id=778 lang=java
 *
 * [778] Swim in Rising Water
 *
 * https://leetcode.com/problems/swim-in-rising-water/description/
 *
 * algorithms
 * Hard (50.04%)
 * Likes:    444
 * Dislikes: 38
 * Total Accepted:    18.9K
 * Total Submissions: 37.4K
 * Testcase Example:  '[[0,2],[1,3]]'
 *
 * On an N x N grid, each square grid[i][j] represents the elevation at that
 * point (i,j).
 *
 * Now rain starts to fall. At time t, the depth of the water everywhere is t.
 * You can swim from a square to another 4-directionally adjacent square if and
 * only if the elevation of both squares individually are at most t. You can
 * swim infinite distance in zero time. Of course, you must stay within the
 * boundaries of the grid during your swim.
 *
 * You start at the top left square (0, 0). What is the least time until you
 * can reach the bottom right square (N-1, N-1)?
 *
 * Example 1:
 *
 *
 * Input: [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have
 * a higher elevation than t = 0.
 *
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 *
 *
 * Example 2:
 *
 *
 * Input:
 * [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 * Output: 16
 * Explanation:
 * ⁠0  1  2  3  4
 * 24 23 22 21  5
 * 12 13 14 15 16
 * 11 17 18 19 20
 * 10  9  8  7  6
 *
 * The final route is marked in bold.
 * We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 *
 *
 * Note:
 *
 *
 * 2 <= N <= 50.
 * grid[i][j] is a permutation of [0, ..., N*N - 1].
 *
 *
 */

// @lc code=start
class Solution {

    private int[] x = {-1, 0, 0, 1};
    private int[] y = {0, -1, 1, 0};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int start = 0;
        int end = n * n - 1;
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (grid[0][0] <= middle && isReachable(grid, new boolean[n][n], n, 0, 0, middle)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return start;
    }

    private boolean isReachable(int[][] grid, boolean[][] isVisited, int n, int x, int y, int t) {
        if (x == n - 1 && y == n - 1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int tempX = x + this.x[i];
            int tempY = y + this.y[i];
            if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n && !isVisited[tempX][tempY] && grid[tempX][tempY] <= t) {
                isVisited[tempX][tempY] = true;
                if (isReachable(grid, isVisited, n, tempX, tempY, t)) {
                    return true;
                }
            }
        }
        return false;
    }

}
// @lc code=end
