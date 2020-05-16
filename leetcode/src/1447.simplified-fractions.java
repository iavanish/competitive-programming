/*
 * @lc app=leetcode id=1447 lang=java
 *
 * [1447] Simplified Fractions
 *
 * https://leetcode.com/problems/simplified-fractions/description/
 *
 * algorithms
 * Medium (55.52%)
 * Likes:    18
 * Dislikes: 0
 * Total Accepted:    5K
 * Total Submissions: 8.9K
 * Testcase Example:  '2\r'
 *
 * Given an integer n, return a list of all simplified fractions between 0 and
 * 1 (exclusive) such that the denominator is less-than-or-equal-to n. The
 * fractions can be in any order.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 2
 * Output: ["1/2"]
 * Explanation: "1/2" is the only unique fraction with a denominator
 * less-than-or-equal-to 2.
 *
 * Example 2:
 *
 *
 * Input: n = 3
 * Output: ["1/2","1/3","2/3"]
 *
 *
 * Example 3:
 *
 *
 * Input: n = 4
 * Output: ["1/2","1/3","1/4","2/3","3/4"]
 * Explanation: "2/4" is not a simplified fraction because it can be simplified
 * to "1/2".
 *
 * Example 4:
 *
 *
 * Input: n = 1
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 100
 *
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {

    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int gcd = gcd(i, j);
                String temp = String.format("%d/%d", i / gcd, j / gcd);
                if (!seen.contains(temp)) {
                    seen.add(temp);
                    result.add(String.format("%d/%d", i, j));
                }
            }
        }

        return result;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

}
// @lc code=end
