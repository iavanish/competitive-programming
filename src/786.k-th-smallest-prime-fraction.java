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

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// @lc code=start
class Solution {

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            priorityQueue.add(new Pair(A, 0, i));
        }

        while (K-- > 1) {
            Pair pair = priorityQueue.poll();
            if (pair.numerator != pair.denominator-1) {
                priorityQueue.add(new Pair(A, pair.numerator+1, pair.denominator));
            }
        }

        return new int[] {
                A[priorityQueue.peek().numerator],
                A[priorityQueue.peek().denominator]
        };
    }

    private static class Pair implements Comparable<Pair> {
        public int numerator;
        public int denominator;
        public Float value;
        public Pair(int[] A, int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            this.value = (float) A[numerator] / (float) A[denominator];
        }
        public int compareTo(Pair pair) {
            return this.value.compareTo(pair.value);
        }
    }

}
// @lc code=end
