/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 *
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * algorithms
 * Hard (40.20%)
 * Likes:    1903
 * Dislikes: 72
 * Total Accepted:    113.9K
 * Total Submissions: 278.7K
 * Testcase Example:  '[5,2,6,1]'
 *
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number of
 * smaller elements to the right of nums[i].
 * 
 * Example:
 * 
 * 
 * Input: [5,2,6,1]
 * Output: [2,1,1,0] 
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// @lc code=start
class Solution {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>();
        }

        int minElement = nums[0];
        int maxElement = nums[0];
        for (int i : nums) {
            minElement = Math.min(minElement, i);
            maxElement = Math.max(maxElement, i);
        }

        int totalElements = maxElement;
        int rebase = 0;
        if (minElement < 0) {
            totalElements = maxElement - minElement + 1;
            rebase = -minElement;
        }
        List<Integer> result = new Stack<>();
        int[] segmentTree = new int[4 * (totalElements+1)];
        result.add(0);
        updateSegmentTree(segmentTree, 0, 0, totalElements, nums[n-1] + rebase);
        for (int i = n-2; i >= 0; i--) {
            result.add(querySegmentTree(segmentTree, 0, 0, totalElements, 0, nums[i] + rebase - 1));
            updateSegmentTree(segmentTree, 0, 0, totalElements, nums[i] + rebase);
        }

        Collections.reverse(result);
        return result;
    }

    private int querySegmentTree(int[] segmentTree, int node, int left, int right, int i, int j) {
        if (right < i || j < left || right < left) {
            return 0;
        }
        else if (i <= left && right <= j) {
            return segmentTree[node];
        }
        int middle = calculateMiddle(left, right);
        return querySegmentTree(segmentTree, node * 2 + 1, left, middle, i, j) +
                querySegmentTree(segmentTree, node * 2 + 2, middle + 1, right, i, j);
    }

    private void updateSegmentTree(int[] segmentTree, int node, int left, int right, int i) {
        if (left == right && left == i) {
            segmentTree[node]++;
        }
        else if (left <= i && i <= right) {
            int middle = calculateMiddle(left, right);
            updateSegmentTree(segmentTree, node * 2 + 1, left, middle, i);
            updateSegmentTree(segmentTree, node * 2 + 2, middle + 1, right, i);
            segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }
    }

    private int calculateMiddle(int left, int right) {
        return left + (right - left) / 2;
    }

}
// @lc code=end
