/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 *
 * https://leetcode.com/problems/flood-fill/description/
 *
 * algorithms
 * Easy (54.68%)
 * Likes:    1046
 * Dislikes: 185
 * Total Accepted:    150.1K
 * Total Submissions: 274.5K
 * Testcase Example:  '[[1,1,1],[1,1,0],[1,0,1]]\n1\n1\n2'
 *
 *
 * An image is represented by a 2-D array of integers, each integer
 * representing the pixel value of the image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column)
 * of the flood fill, and a pixel value newColor, "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color as the starting pixel), and so on.  Replace the
 * color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 *
 * Example 1:
 *
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels
 * connected
 * by a path of the same color as the starting pixel are colored with the new
 * color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally
 * connected
 * to the starting pixel.
 *
 *
 *
 * Note:
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0  and 0 .
 * The value of each color in image[i][j] and newColor will be an integer in
 * [0, 65535].
 *
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        int startingColor = image[sr][sc];
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        rowQueue.offer(sr);
        colQueue.offer(sc);
        image[sr][sc] = newColor;

        int[] nextRow = {-1, 0, 0, 1};
        int[] nextCol = {0, -1, 1, 0};

        while (!rowQueue.isEmpty()) {
            int tr = rowQueue.poll();
            int tc = colQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = tr + nextRow[i];
                int nc = tc + nextCol[i];
                if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == startingColor) {
                    rowQueue.offer(nr);
                    colQueue.offer(nc);
                    image[nr][nc] = newColor;
                }
            }
        }

        return image;
    }

}
// @lc code=end
