/*
 * @lc app=leetcode id=1020 lang=java
 *
 * [1020] Number of Enclaves
 *
 * https://leetcode.com/problems/number-of-enclaves/description/
 *
 * algorithms
 * Medium (56.96%)
 * Likes:    257
 * Dislikes: 17
 * Total Accepted:    16.6K
 * Total Submissions: 29.1K
 * Testcase Example:  '[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]'
 *
 * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing
 * land)
 *
 * A move consists of walking from one land square 4-directionally to another
 * land square, or off the boundary of the grid.
 *
 * Return the number of land squares in the grid for which we cannot walk off
 * the boundary of the grid in any number of moves.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation:
 * There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed
 * because its on the boundary.
 *
 * Example 2:
 *
 *
 * Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation:
 * All 1s are either on the boundary or can reach the boundary.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * All rows have the same size.
 *
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {

    private final int[] x = {-1, 0, 0, 1};
    private final int[] y = {0, -1, 1, 0};

    public int numEnclaves(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int numEnclaves = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    numEnclaves += bfs(A, i, j, m, n);
                }
            }
        }

        return numEnclaves;
    }

    private int bfs(int[][] a, int i, int j, int m, int n) {
        Queue<Pair> queue = new LinkedList<>();
        a[i][j] = 0;
        queue.offer(new Pair(i, j));
        int count = 1;
        boolean canFallOff = false;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int t = 0; t < 4; t++) {
                int nextI = pair.i + x[t];
                int nextJ = pair.j + y[t];
                if (nextI == -1 || nextI == m || nextJ == -1 || nextJ == n) {
                    canFallOff = true;
                } else if (a[nextI][nextJ] == 1) {
                    a[nextI][nextJ] = 0;
                    queue.offer(new Pair(nextI, nextJ));
                    count++;
                }
            }
        }

        if (canFallOff) {
            count = 0;
        }
        return count;
    }

    private static class Pair {

        public int i;
        public int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

}
// @lc code=end
