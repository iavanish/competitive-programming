/*
 * @lc app=leetcode id=852 lang=java
 *
 * [852] Peak Index in a Mountain Array
 *
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 *
 * algorithms
 * Easy (70.59%)
 * Likes:    465
 * Dislikes: 966
 * Total Accepted:    127.8K
 * Total Submissions: 180.3K
 * Testcase Example:  '[0,1,0]'
 *
 * Let's call an array A a mountain if the following properties hold:
 * 
 * 
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] <
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * 
 * 
 * Given an array that is definitely a mountain, return any i such that A[0] <
 * A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * 
 * Example 1:
 * 
 * 
 * Input: [0,1,0]
 * Output: 1
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,2,1,0]
 * Output: 1
 * 
 * 
 * Note:
 * 
 * 
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 * 
 * 
 */

// @lc code=start
class Solution {

    public int peakIndexInMountainArray(int[] A) {
        int first = 0;
        int last = A.length - 1;
        while (first <= last) {
            int middle = first + (last - first) / 2;
            if (A[middle-1] < A[middle] && A[middle+1] < A[middle]) {
                return middle;
            }
            else if (A[middle-1] < A[middle] && A[middle] < A[middle+1]) {
                first = middle + 1;
            }
            else {
                last = middle - 1;
            }
        }

        return -1;
    }

}
// @lc code=end
