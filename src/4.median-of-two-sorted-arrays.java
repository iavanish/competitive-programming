/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (28.02%)
 * Likes:    5618
 * Dislikes: 838
 * Total Accepted:    565.5K
 * Total Submissions: 2M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (n + m) % 2 == 0 ? (n + m) / 2 - 1 : (n + m) / 2;

        if (n == 0) {
            return m % 2 == 0 ? (nums1[mid] + nums1[mid+1]) / 2.0 : nums1[mid];
        }
        if (m == 0) {
            return n % 2 == 0 ? (nums2[mid] + nums2[mid+1]) / 2.0 : nums2[mid];
        }

        int median = binarySearch(nums1, nums2, m, n, mid);
        if ((n + m) % 2 != 0) {
            return median;
        }
        return (median + binarySearch(nums1, nums2, m, n, mid+1)) / 2.0;
    }

    private int binarySearch(int[] nums1, int[] nums2, int m, int n, int mid) {
        int first = Math.min(nums1[0], nums2[0]);
        int last = Math.max(nums1[m-1], nums2[n-1]);
        while (first < last) {
            int middle = first + (last - first) / 2;
            int pos1 = Arrays.binarySearch(nums1, middle);
            int pos2 = Arrays.binarySearch(nums2, middle);
            if (pos1 < 0) {
                pos1 *= -1;
                pos1--;
            }
            if (pos2 < 0) {
                pos2 *= -1;
                pos2--;
            }
            while (pos1 >= 0 && pos1 < m && nums1[pos1] == middle) {
                pos1++;
            }
            while (pos2 >= 0 && pos2 < n && nums2[pos2] == middle) {
                pos2++;
            }
            if (pos1 + pos2 <= mid) {
                first = middle + 1;
            }
            else {
                last = middle;
            }
        }
        return first;
    }

}
// @lc code=end
