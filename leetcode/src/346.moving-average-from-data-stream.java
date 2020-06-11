/*
 * @lc app=leetcode id=346 lang=java
 *
 * [346] Moving Average from Data Stream
 *
 * https://leetcode.com/problems/moving-average-from-data-stream/description/
 *
 * algorithms
 * Easy (68.50%)
 * Likes:    437
 * Dislikes: 47
 * Total Accepted:    101.3K
 * Total Submissions: 147.5K
 * Testcase Example:  '["MovingAverage","next","next","next","next"]\n[[3],[1],[10],[3],[5]]'
 *
 * Given a stream of integers and a window size, calculate the moving average
 * of all integers in the sliding window.
 *
 * Example:
 *
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 *
 *
 *
 */

import java.util.LinkedList;
import java.util.Queue;

// @lc code=start
class MovingAverage {

    int sum;
    int size;
    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        sum = 0;
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        sum += val;
        if (queue.size() > size) {
            sum -= queue.poll();
        }
        return (double) sum / (double) queue.size();
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
// @lc code=end
