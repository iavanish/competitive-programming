/*
 * @lc app=leetcode id=835 lang=java
 *
 * [835] Image Overlap
 *
 * https://leetcode.com/problems/image-overlap/description/
 *
 * algorithms
 * Medium (58.16%)
 * Likes:    328
 * Dislikes: 445
 * Total Accepted:    20.8K
 * Total Submissions: 35.7K
 * Testcase Example:  '[[1,1,0],[0,1,0],[0,1,0]]\n[[0,0,0],[0,1,1],[0,0,1]]'
 *
 * Two images A and B are given, represented as binary, square matrices of the
 * same size.  (A binary matrix has only 0s and 1s as values.)
 *
 * We translate one image however we choose (sliding it left, right, up, or
 * down any number of units), and place it on top of the other image.  After,
 * the overlap of this translation is the number of positions that have a 1 in
 * both images.
 *
 * (Note also that a translation does not include any kind of rotation.)
 *
 * What is the largest possible overlap?
 *
 * Example 1:
 *
 *
 * Input: A = [[1,1,0],
 * ⁠           [0,1,0],
 * [0,1,0]]
 * B = [[0,0,0],
 * [0,1,1],
 * [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 *
 * Notes: 
 *
 *
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 *
 *
 */

// @lc code=start
class Solution {

    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int largestOverlap = 0;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                int temp1 = 0;
                int temp2 = 0;
                for (int c = a, i = 0; c < n; c++, i++) {
                    for (int d = b, j = 0; d < n; d++, j++) {
                        if (A[c][d] == B[i][j] && A[c][d] == 1) {
                            temp1++;
                        }
                        if (B[c][d] == A[i][j] && B[c][d] == 1) {
                            temp2++;
                        }
                    }
                }
                largestOverlap = Math.max(largestOverlap, Math.max(temp1, temp2));
            }
        }

        return largestOverlap;
    }

}
// @lc code=end
