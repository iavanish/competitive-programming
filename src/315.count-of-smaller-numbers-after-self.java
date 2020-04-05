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

        int maxElement = nums[0];
        int minElement = nums[0];
        for (int i : nums) {
            maxElement = Math.max(maxElement, i);
            minElement = Math.min(minElement, i);
        }

        int totalElements = maxElement;
        int rebase = 0;
        if (minElement < 0) {
            totalElements = maxElement - minElement + 1;
            rebase = -minElement;
        }
        List<Integer> result = new Stack<>();
        int[] count = new int[totalElements+1];
        result.add(0);
        count[nums[n-1] + rebase]++;
        for (int i = n-2; i >= 0; i--) {
            int temp = 0;
            for (int j = 0; j < nums[i] + rebase; j++) {
                temp += count[j];
            }
            result.add(temp);
            count[nums[i] + rebase]++;
        }

        Collections.reverse(result);
        return result;
    }

}
// @lc code=end
