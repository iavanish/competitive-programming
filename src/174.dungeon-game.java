/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 *
 * https://leetcode.com/problems/dungeon-game/description/
 *
 * algorithms
 * Hard (28.55%)
 * Likes:    1012
 * Dislikes: 27
 * Total Accepted:    79.1K
 * Total Submissions: 273.1K
 * Testcase Example:  '[[-2,-3,3],[-5,-10,1],[10,30,-5]]'
 *
 * table.dungeon, .dungeon th, .dungeon td {
 * ⁠ border:3px solid black;
 * }
 * 
 * ⁠.dungeon th, .dungeon td {
 * ⁠   text-align: center;
 * ⁠   height: 70px;
 * ⁠   width: 70px;
 * }
 * 
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health
 * (negative integers) upon entering these rooms; other rooms are either empty
 * (0's) or contain magic orbs that increase the knight's health (positive
 * integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * 
 * 
 * Write a function to determine the knight's minimum initial health so that he
 * is able to rescue the princess.
 * 
 * For example, given the dungeon below, the initial health of the knight must
 * be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN ->
 * DOWN.
 * 
 * 
 * 
 * 
 * -2 (K)
 * -3
 * 3
 * 
 * 
 * -5
 * -10
 * 1
 * 
 * 
 * 10
 * 30
 * -5 (P)
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight
 * enters and the bottom-right room where the princess is imprisoned.
 * 
 * 
 */

import java.util.TreeMap;

// @lc code=start
class Solution {

    private int[] x = {0, 1};
    private int[] y = {1, 0};

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if (m == 0) {
            return 0;
        }
        int n = dungeon[0].length;


        long start = 1;
        long end = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dungeon[i][j] < 0) {
                    end += dungeon[i][j];
                }
            }
        }
        end = -1 * end + 1;
        System.out.println(end);
        while (start < end) {
            long middle = start + (end - start) / 2;
            if (isPossible(dungeon, 0, 0, m, n, dungeon[0][0], middle, isVisited(m, n))) {
                end = middle;
            }
            else {
                start = middle + 1;
            }
        }

        return (int) start;
    }

    private long[][] isVisited(int m, int n) {
        long[][] isVisited = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                isVisited[i][j] = Integer.MIN_VALUE;
            }
        }
        return isVisited;
    }

    private boolean isPossible(int[][] dungean, int x, int y, int m, int n, long currValue, long t, long[][] isVisited) {
        isVisited[x][y] = currValue;
        if (t + currValue <= 0) {
            return false;
        }
        if (x == m-1 && y == n-1) {
            return true;
        }
        for (int i = 0; i < 2; i++) {
            int tempX = x + this.x[i];
            int tempY = y + this.y[i];
            if (tempX >= 0 && tempX < m && tempY >= 0 && tempY < n && isVisited[tempX][tempY] < currValue + dungean[tempX][tempY]) {
                if (isPossible(dungean, tempX, tempY, m, n, currValue + dungean[tempX][tempY], t, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

}
// @lc code=end
