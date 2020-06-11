/*
 * @lc app=leetcode id=786 lang=java
 *
 * [786] K-th Smallest Prime Fraction
 *
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/description/
 *
 * algorithms
 * Hard (41.48%)
 * Likes:    306
 * Dislikes: 17
 * Total Accepted:    11.4K
 * Total Submissions: 27.3K
 * Testcase Example:  '[1,2,3,5]\n3'
 *
 * A sorted list A contains 1, plus some number of primes.  Then, for every p <
 * q in the list, we consider the fraction p/q.
 *
 * What is the K-th smallest fraction considered?  Return your answer as an
 * array of ints, where answer[0] = p and answer[1] = q.
 *
 *
 * Examples:
 * Input: A = [1, 2, 3, 5], K = 3
 * Output: [2, 5]
 * Explanation:
 * The fractions to be considered in sorted order are:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
 * The third fraction is 2/5.
 *
 * Input: A = [1, 7], K = 1
 * Output: [1, 7]
 *
 *
 * Note:
 *
 *
 * A will have length between 2 and 2000.
 * Each A[i] will be between 1 and 30000.
 * K will be between 1 and A.length * (A.length - 1) / 2.
 *
 */

// @lc code=start
class Solution {

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;

        int[] result = new int[2];
        double start = 0f;
        double end = 1f;
        while (start < end - 1e-9) {
            double middle = start + (end - start) / 2f;
            int count = 0;
            int i = -1;
            int numerator = 0;
            int denominator = A[0];
            for (int j = 1; j < n; j++) {
                while ((double) A[i + 1] / (double) A[j] <= middle) {
                    i++;
                }
                count += (i + 1);
                if ((i >= 0) && ((double) numerator / (double) denominator <= (double) A[i] / (double) A[j])) {
                    numerator = A[i];
                    denominator = A[j];
                }
            }

            if (count < K) {
                start = middle;
            } else {
                end = middle;
                result[0] = numerator;
                result[1] = denominator;
            }
        }

        return result;
    }

}
// @lc code=end
