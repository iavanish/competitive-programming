/*
 * @lc app=leetcode id=1320 lang=java
 *
 * [1320] Minimum Distance to Type a Word Using Two Fingers
 *
 * https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/description/
 *
 * algorithms
 * Hard (60.65%)
 * Likes:    317
 * Dislikes: 13
 * Total Accepted:    10.5K
 * Total Submissions: 17.2K
 * Testcase Example:  '"CAKE"'
 *
 *
 *
 * You have a keyboard layout as shown above in the XY plane, where each
 * English uppercase letter is located at some coordinate, for example, the
 * letter A is located at coordinate (0,0), the letter B is located at
 * coordinate (0,1), the letter P is located at coordinate (2,3) and the letter
 * Z is located at coordinate (4,1).
 *
 * Given the string word, return the minimum total distance to type such string
 * using only two fingers. The distance between coordinates (x1,y1) and (x2,y2)
 * is |x1 - x2| + |y1 - y2|. 
 *
 * Note that the initial positions of your two fingers are considered free so
 * don't count towards your total distance, also your two fingers do not have
 * to start at the first letter or the first two letters.
 *
 *
 * Example 1:
 *
 *
 * Input: word = "CAKE"
 * Output: 3
 * Explanation:
 * Using two fingers, one optimal way to type "CAKE" is:
 * Finger 1 on letter 'C' -> cost = 0
 * Finger 1 on letter 'A' -> cost = Distance from letter 'C' to letter 'A' = 2
 * Finger 2 on letter 'K' -> cost = 0
 * Finger 2 on letter 'E' -> cost = Distance from letter 'K' to letter 'E' = 1
 * Total distance = 3
 *
 *
 * Example 2:
 *
 *
 * Input: word = "HAPPY"
 * Output: 6
 * Explanation:
 * Using two fingers, one optimal way to type "HAPPY" is:
 * Finger 1 on letter 'H' -> cost = 0
 * Finger 1 on letter 'A' -> cost = Distance from letter 'H' to letter 'A' = 2
 * Finger 2 on letter 'P' -> cost = 0
 * Finger 2 on letter 'P' -> cost = Distance from letter 'P' to letter 'P' = 0
 * Finger 1 on letter 'Y' -> cost = Distance from letter 'A' to letter 'Y' = 4
 * Total distance = 6
 *
 *
 * Example 3:
 *
 *
 * Input: word = "NEW"
 * Output: 3
 *
 *
 * Example 4:
 *
 *
 * Input: word = "YEAR"
 * Output: 7
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= word.length <= 300
 * Each word[i] is an English uppercase letter.
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {

    private int[][][] dp;

    public int minimumDistance(String word) {
        int[][] cost = new int[31][31];
        List<Coordinate> grid = new ArrayList<>();
        for (int i = 0, k = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++, k++) {
                grid.add(new Coordinate(i, j));
                for (int x = 0, l = 0; x < 5; x++) {
                    for (int y = 0; y < 6; y++, l++) {
                        cost[k][l] = Math.abs(i - x) + Math.abs(j - y);
                    }
                }
            }
        }

        dp = new int[word.length()][grid.size()][grid.size()];
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int minimumDistance = Integer.MAX_VALUE;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                minimumDistance = Math.min(minimumDistance, minimumDistance(word, 0, grid, i, j, cost));
            }
        }
        return minimumDistance;
    }

    private int minimumDistance(String word, int currIndex, List<Coordinate> grid, int lastCharLeft, int lastCharRight, int[][] cost) {
        if (word.length() == currIndex) {
            return 0;
        }

        if (dp[currIndex][lastCharLeft][lastCharRight] != -1) {
            return dp[currIndex][lastCharLeft][lastCharRight];
        }

        int nextChar = word.charAt(currIndex) - 'A';
        int leftMove = cost[lastCharLeft][nextChar] + minimumDistance(word, currIndex + 1, grid, nextChar, lastCharRight, cost);
        int rightMove = cost[lastCharRight][nextChar] + minimumDistance(word, currIndex + 1, grid, lastCharLeft, nextChar, cost);
        return dp[currIndex][lastCharLeft][lastCharRight] = Math.min(leftMove, rightMove);
    }

    private static class Coordinate {

        public int i;
        public int j;

        public Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

}
// @lc code=end
