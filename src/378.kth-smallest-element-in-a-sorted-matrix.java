/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (51.68%)
 * Likes:    1798
 * Dislikes: 106
 * Total Accepted:    154.4K
 * Total Submissions: 295.6K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * 
 * Example:
 * 
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * 
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n^2.
 */

import java.util.PriorityQueue;

// @lc code=start
class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Cell> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(new Cell(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k-1; i++) {
            Cell cell = priorityQueue.poll();
            if (cell.i != n-1) {
                priorityQueue.add(new Cell(cell.i+1, cell.j, matrix[cell.i+1][cell.j]));
            }
        }

        return priorityQueue.peek().val;
    }

    private static class Cell implements Comparable<Cell> {
        public int i;
        public int j;
        public int val;
        public Cell(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
        @Override
        public int compareTo(Cell cell) {
            return this.val - cell.val;
        }
    }

}
// @lc code=end
