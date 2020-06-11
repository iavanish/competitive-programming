/*
 * @lc app=leetcode id=1232 lang=java
 *
 * [1232] Check If It Is a Straight Line
 *
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
 *
 * algorithms
 * Easy (48.93%)
 * Likes:    299
 * Dislikes: 44
 * Total Accepted:    66.4K
 * Total Submissions: 135.3K
 * Testcase Example:  '[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]'
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
 * represents the coordinate of a point. Check if these points make a straight
 * line in the XY plane.
 *
 *
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 *
 * Example 2:
 *
 *
 *
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 *
 *
 */

// @lc code=start
class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        double slope = slope(coordinates, 0, 1);
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = i + 1; j < coordinates.length; j++) {
                if (slope != slope(coordinates, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private double slope(int[][] coordinates, int i, int j) {
        return (double) (coordinates[i][1] - coordinates[j][1]) / (double) (coordinates[i][0] - coordinates[j][0]);
    }

}
// @lc code=end
