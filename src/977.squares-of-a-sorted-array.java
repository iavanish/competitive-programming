/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 *
 * https://leetcode.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (71.95%)
 * Likes:    782
 * Dislikes: 72
 * Total Accepted:    157.1K
 * Total Submissions: 217.7K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 * 
 * 
 * 
 */

// @lc code=start
class Solution {

    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int positiveIndex = 0;
        while (positiveIndex < n && A[positiveIndex] < 0) {
            positiveIndex++;
        }
        int negativeIndex = positiveIndex-1;

        int[] sortedSquares = new int[n];
        int index = 0;
        while (negativeIndex >= 0 && positiveIndex < n) {
            int negativeSquare = A[negativeIndex] * A[negativeIndex];
            int positiveSquare = A[positiveIndex] * A[positiveIndex];
            if (negativeSquare < positiveSquare) {
                sortedSquares[index++] = negativeSquare;
                negativeIndex--;
            }
            else {
                sortedSquares[index++] = positiveSquare;
                positiveIndex++;
            }
        }
        while (negativeIndex >= 0) {
            sortedSquares[index++] = A[negativeIndex] * A[negativeIndex--];
        }
        while (positiveIndex < n) {
            sortedSquares[index++] = A[positiveIndex] * A[positiveIndex++];
        }

        return sortedSquares;
    }

}
// @lc code=end
