/*
 * @lc app=leetcode id=1424 lang=java
 *
 * [1424] Diagonal Traverse II
 *
 * https://leetcode.com/problems/diagonal-traverse-ii/description/
 *
 * algorithms
 * Medium (21.59%)
 * Likes:    9
 * Dislikes: 5
 * Total Accepted:    2.1K
 * Total Submissions: 9.5K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a list of lists of integers, nums, return all elements of nums in
 * diagonal order as shown in the below images.
 *
 * Example 1:
 *
 *
 *
 *
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,4,2,7,5,3,8,6,9]
 *
 *
 * Example 2:
 *
 *
 *
 *
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
 * Output: [1,4,2,5,3,8,6,9,7,10,11]
 *
 *
 * Example 4:
 *
 *
 * Input: nums = [[1,2,3,4,5,6]]
 * Output: [1,2,3,4,5,6]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i].length <= 10^5
 * 1 <= nums[i][j] <= 10^9
 * There at most 10^5 elements in nums.
 *
 *
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

// @lc code=start
class Solution {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> diagonalOrder = new ArrayList<>();
        Set<Cell> visited = new HashSet<>();
        Queue<Cell> queue = new LinkedList<>();

        Cell cell = new Cell(0, 0);
        if (exists(nums, cell)) {
            visited.add(cell);
            queue.offer(cell);
        }

        while (!queue.isEmpty()) {
            cell = queue.poll();
            diagonalOrder.add(nums.get(cell.i).get(cell.j));
            Cell temp = new Cell(cell.i + 1, cell.j);
            if (exists(nums, temp) && !visited.contains(temp)) {
                visited.add(temp);
                queue.offer(temp);
            }
            temp = new Cell(cell.i, cell.j + 1);
            if (exists(nums, temp) && !visited.contains(temp)) {
                visited.add(temp);
                queue.offer(temp);
            }
        }

        int[] result = new int[diagonalOrder.size()];
        for (int i = 0; i < diagonalOrder.size(); i++) {
            result[i] = diagonalOrder.get(i);
        }

        return result;
    }

    private boolean exists(List<List<Integer>> nums, Cell cell) {
        return cell.i < nums.size() && cell.j < nums.get(cell.i).size();
    }

    private static class Cell {

        public int i;
        public int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return i == cell.i &&
                    j == cell.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

    }

}
// @lc code=end
