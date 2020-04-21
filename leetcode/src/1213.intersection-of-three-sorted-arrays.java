/*
 * @lc app=leetcode id=1213 lang=java
 *
 * [1213] Intersection of Three Sorted Arrays
 *
 * https://leetcode.com/problems/intersection-of-three-sorted-arrays/description/
 *
 * algorithms
 * Easy (77.26%)
 * Likes:    75
 * Dislikes: 4
 * Total Accepted:    10.9K
 * Total Submissions: 14.1K
 * Testcase Example:  '[1,2,3,4,5]\n[1,2,5,7,9]\n[1,3,4,5,8]'
 *
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing
 * order, return a sorted array of only the integers that appeared in all three
 * arrays.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < arr1.length && j < arr2.length && k < arr3.length) {
            int min = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
            while(i < arr1.length && arr1[i] < min) {
                i++;
            }
            while(j < arr2.length && arr2[j] < min) {
                j++;
            }
            while(k < arr3.length && arr3[k] < min) {
                k++;
            }
            if(i < arr1.length && j < arr2.length && k < arr3.length && min == arr1[i] && min == arr2[j] && min == arr3[k]) {
                intersection.add(min);
                i++;
                j++;
                k++;
            }
            else if(arr1[i] == min) {
                i++;
            }
            else if(arr2[j] == min) {
                j++;
            }
            else {
                k++;
            }
        }

        return intersection;
    }

}
// @lc code=end
