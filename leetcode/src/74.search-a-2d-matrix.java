/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (35.67%)
 * Likes:    1324
 * Dislikes: 140
 * Total Accepted:    286.1K
 * Total Submissions: 797.6K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 * 
 */

// @lc code=start
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int first = 0;
        int last = matrix.length - 1;
        while (first <= last) {
            int middle = first + (last - first) / 2;
            if (matrix[middle][0] == target) {
                return true;
            }
            else if (matrix[middle][0] < target) {
                first = middle + 1;
            }
            else {
                last = middle - 1;
            }
        }

        if (last == -1) {
            return false;
        }

        int pivot = last;
        first = 0;
        last = matrix[0].length - 1;
        while (first <= last) {
            int middle = first + (last - first) / 2;
            if (matrix[pivot][middle] == target) {
                return true;
            }
            else if (matrix[pivot][middle] < target) {
                first = middle + 1;
            }
            else {
                last = middle - 1;
            }
        }

        return false;
    }

}
// @lc code=end
