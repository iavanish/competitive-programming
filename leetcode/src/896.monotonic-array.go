/*
 * @lc app=leetcode id=896 lang=golang
 *
 * [896] Monotonic Array
 *
 * https://leetcode.com/problems/monotonic-array/description/
 *
 * algorithms
 * Easy (57.53%)
 * Likes:    629
 * Dislikes: 35
 * Total Accepted:    102.6K
 * Total Submissions: 178K
 * Testcase Example:  '[1,2,2,3]'
 *
 * An array is monotonic if it is either monotone increasing or monotone
 * decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array
 * A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 *
 *
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [1,2,2,3]
 * Output: true
 *
 *
 *
 * Example 2:
 *
 *
 * Input: [6,5,4,4]
 * Output: true
 *
 *
 *
 * Example 3:
 *
 *
 * Input: [1,3,2]
 * Output: false
 *
 *
 *
 * Example 4:
 *
 *
 * Input: [1,2,4,5]
 * Output: true
 *
 *
 *
 * Example 5:
 *
 *
 * Input: [1,1,1]
 * Output: true
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 *
 *
 *
 *
 *
 *
 *
 */

// @lc code=start
func isMonotonic(A []int) bool {
	return isMonotonicIncreasing(A) || isMonotonicDecreasing(A)
}

func isMonotonicIncreasing(A []int) bool  {
	for i := 1; i < len(A); i++ {
		if A[i] < A[i - 1] {
			return false
		}
	}
	return true
}

func isMonotonicDecreasing(A []int) bool  {
	for i := 1; i < len(A); i++ {
		if A[i] > A[i - 1] {
			return false
		}
	}
	return true
}
// @lc code=end
