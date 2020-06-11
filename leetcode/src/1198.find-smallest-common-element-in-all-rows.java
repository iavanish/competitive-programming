/*
 * @lc app=leetcode id=1198 lang=java
 *
 * [1198] Find Smallest Common Element in All Rows
 *
 * https://leetcode.com/problems/find-smallest-common-element-in-all-rows/description/
 *
 * algorithms
 * Medium (73.87%)
 * Likes:    65
 * Dislikes: 7
 * Total Accepted:    5.8K
 * Total Submissions: 7.8K
 * Testcase Example:  '[[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]'
 *
 * Given a matrix mat where every row is sorted in increasing order, return the
 * smallest common element in all rows.
 *
 * If there is no common element, return -1.
 *
 *
 *
 * Example 1:
 * Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
 * Output: 5
 *
 *
 * Constraints:
 *
 *
 * 1 <= mat.length, mat[i].length <= 500
 * 1 <= mat[i][j] <= 10^4
 * mat[i] is sorted in increasing order.
 *
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// @lc code=start
class Solution {

    public int smallestCommonElement(int[][] mat) {
        List<Queue<Integer>> queues = new ArrayList<>();
        for (int[] m : mat) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i : m) {
                queue.add(i);
            }
            queues.add(queue);
        }

        boolean flag = true;
        while (true) {
            for (int i = 1; i < queues.size(); i++) {
                if (queues.get(0).isEmpty() || queues.get(i).isEmpty()) {
                    return -1;
                }
                while (!queues.get(0).isEmpty() && queues.get(0).peek() < queues.get(i).peek()) {
                    queues.get(0).poll();
                    flag = false;
                }
                if (queues.get(0).isEmpty()) {
                    return -1;
                }
                while (!queues.get(i).isEmpty() && queues.get(i).peek() < queues.get(0).peek()) {
                    queues.get(i).poll();
                    flag = false;
                }
                if (queues.get(i).isEmpty()) {
                    return -1;
                }
            }
            if (flag) {
                break;
            }
            flag = true;
        }

        return queues.get(0).peek();
    }

}
// @lc code=end
