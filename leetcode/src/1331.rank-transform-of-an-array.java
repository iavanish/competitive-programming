/*
 * @lc app=leetcode id=1331 lang=java
 *
 * [1331] Rank Transform of an Array
 *
 * https://leetcode.com/problems/rank-transform-of-an-array/description/
 *
 * algorithms
 * Easy (58.34%)
 * Likes:    206
 * Dislikes: 16
 * Total Accepted:    13.5K
 * Total Submissions: 23.2K
 * Testcase Example:  '[40,10,20,30]'
 *
 * Given an array of integers arr, replace each element with its rank.
 *
 * The rank represents how large the element is. The rank has the following
 * rules:
 *
 *
 * Rank is an integer starting from 1.
 * The larger the element, the larger the rank. If two elements are equal,
 * their rank must be the same.
 * Rank should be as small as possible.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: arr = [40,10,20,30]
 * Output: [4,1,2,3]
 * Explanation: 40 is the largest element. 10 is the smallest. 20 is the second
 * smallest. 30 is the third smallest.
 *
 * Example 2:
 *
 *
 * Input: arr = [100,100,100]
 * Output: [1,1,1]
 * Explanation: Same elements share the same rank.
 *
 *
 * Example 3:
 *
 *
 * Input: arr = [37,12,28,9,100,56,80,5,12]
 * Output: [5,3,4,2,8,6,7,1,3]
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= arr.length <= 10^5
 * -10^9 <= arr[i] <= 10^9
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {

    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Collections.binarySearch(sortedList, arr[i]) + 1;
        }

        return arr;
    }

}
// @lc code=end
