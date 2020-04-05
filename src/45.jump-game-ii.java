/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (29.40%)
 * Likes:    2032
 * Dislikes: 117
 * Total Accepted:    232.7K
 * Total Submissions: 778.9K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * ⁠   Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Note:
 *
 * You can assume that you can always reach the last index.
 *
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        for (int i = 1; i < n; i++) {
            while (queue.peek().index + nums[queue.peek().index] < i) {
                queue.poll();
            }
            queue.offer(new Pair(i, queue.peek().minJump + 1));
        }
        while (queue.size() > 1) {
            queue.poll();
        }
        return queue.poll().minJump;
    }

    private static class Pair {
        public int index;
        public int minJump;
        public Pair(int index, int minJump) {
            this.index = index;
            this.minJump = minJump;
        }
    }

}
// @lc code=end
