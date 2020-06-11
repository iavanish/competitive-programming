/*
 * @lc app=leetcode id=1414 lang=java
 *
 * [1414] Find the Minimum Number of Fibonacci Numbers Whose Sum Is K
 *
 * https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/description/
 *
 * algorithms
 * Medium (60.19%)
 * Likes:    151
 * Dislikes: 21
 * Total Accepted:    9.5K
 * Total Submissions: 15.8K
 * Testcase Example:  '7'
 *
 * Given the number k, return the minimum number of Fibonacci numbers whose sum
 * is equal to k, whether a Fibonacci number could be used multiple times.
 *
 * The Fibonacci numbers are defined as:
 *
 *
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 , for n > 2.
 *
 * It is guaranteed that for the given constraints we can always find such
 * fibonacci numbers that sum k.
 *
 * Example 1:
 *
 *
 * Input: k = 7
 * Output: 2
 * Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ...
 * For k = 7 we can use 2 + 5 = 7.
 *
 * Example 2:
 *
 *
 * Input: k = 10
 * Output: 2
 * Explanation: For k = 10 we can use 2 + 8 = 10.
 *
 *
 * Example 3:
 *
 *
 * Input: k = 19
 * Output: 3
 * Explanation: For k = 19 we can use 1 + 5 + 13 = 19.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= k <= 10^9
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {

    private Map<Long, Integer> dp;

    public int findMinFibonacciNumbers(int k) {
        List<Long> fibonacciNumbers = generateFibonacciNumbers();

        dp = new HashMap<>();
        for (Long fibonacciNumber : fibonacciNumbers) {
            dp.put(fibonacciNumber, 1);
        }

        return findMinFibonacciNumbers(fibonacciNumbers, k);
    }

    private List<Long> generateFibonacciNumbers() {
        List<Long> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(1L);
        fibonacciNumbers.add(1L);
        int i = 2;
        while (fibonacciNumbers.get(i - 1) <= 1_000_000_000) {
            fibonacciNumbers.add(fibonacciNumbers.get(i - 1) + fibonacciNumbers.get(i - 2));
            i++;
        }
        return fibonacciNumbers;
    }

    private int findMinFibonacciNumbers(List<Long> fibonacciNumbers, long k) {
        if (k == 0) {
            return 0;
        }
        if (dp.containsKey(k)) {
            return dp.get(k);
        }
        int findMinFibonacciNumbers = Integer.MAX_VALUE;
        for (Long fibonacciNumber : fibonacciNumbers) {
            if (fibonacciNumber <= k) {
                findMinFibonacciNumbers = Math.min(findMinFibonacciNumbers, (int) (k / fibonacciNumber) + findMinFibonacciNumbers(fibonacciNumbers, k % fibonacciNumber));
            }
        }
        dp.put(k, findMinFibonacciNumbers);
        return findMinFibonacciNumbers;
    }

}
// @lc code=end
