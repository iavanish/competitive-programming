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
        int mid1 = (m + n) % 2 != 0 ? (m + n) / 2 : (m + n) / 2 - 1;
        int mid2 = (m + n) / 2;

        if (n == 0) {
            return (nums1[mid1] + nums1[mid2]) / 2.0;
        }
        if (m == 0) {
            return (nums2[mid1] + nums2[mid2]) / 2.0;
        }

        int median1 = findNthElement(nums1, nums2, 0, m - 1, 0, n - 1, mid1);
        int median2 = findNthElement(nums1, nums2, 0, m - 1, 0, n - 1, mid2);
        return (median1 + median2) / 2.0;
    }

    private int findNthElement(int[] nums1, int[] nums2, int i1, int j1, int i2, int j2, int n) {
        if (j1 < i1) {
            return nums2[i2 + n];
        }
        if (j2 < i2) {
            return nums1[i1 + n];
        }

        int pos1 = i1 + (j1 - i1) / 2;
        int pos2 = Arrays.binarySearch(nums2, i2, j2 + 1, nums1[pos1]);
        if (pos2 < 0) {
            pos2 *= -1;
            pos2 -= 2;
        }
        int i = (pos1 - i1) + (pos2 - i2) + 1;
        if (i == n) {
            return nums1[pos1];
        }
        if (i < n) {
            return findNthElement(nums1, nums2, pos1 + 1, j1, pos2 + 1, j2, n - i - 1);
        }
        if (pos2 < 0 || nums2[pos2] <= nums1[pos1]) {
            return findNthElement(nums1, nums2, i1, pos1 - 1, i2, pos2, n);
        }
        return findNthElement(nums1, nums2, i1, pos1, i2, pos2 - 1, n);
    }

}
// @lc code=end
