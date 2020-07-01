/*
 * @lc app=leetcode id=1415 lang=java
 *
 * [1415] The k-th Lexicographical String of All Happy Strings of Length n
 *
 * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/
 *
 * algorithms
 * Medium (70.70%)
 * Likes:    175
 * Dislikes: 8
 * Total Accepted:    9.2K
 * Total Submissions: 13.1K
 * Testcase Example:  '1\n3'
 *
 * A happy string is a string that:
 *
 *
 * consists only of letters of the set ['a', 'b', 'c'].
 * s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is
 * 1-indexed).
 *
 *
 * For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings
 * and strings "aa", "baa" and "ababbc" are not happy strings.
 *
 * Given two integers n and k, consider a list of all happy strings of length n
 * sorted in lexicographical order.
 *
 * Return the kth string of this list or return an empty string if there are
 * less than k happy strings of length n.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 1, k = 3
 * Output: "c"
 * Explanation: The list ["a", "b", "c"] contains all happy strings of length
 * 1. The third string is "c".
 *
 *
 * Example 2:
 *
 *
 * Input: n = 1, k = 4
 * Output: ""
 * Explanation: There are only 3 happy strings of length 1.
 *
 *
 * Example 3:
 *
 *
 * Input: n = 3, k = 9
 * Output: "cab"
 * Explanation: There are 12 different happy string of length 3 ["aba", "abc",
 * "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You
 * will find the 9th string = "cab"
 *
 *
 * Example 4:
 *
 *
 * Input: n = 2, k = 7
 * Output: ""
 *
 *
 * Example 5:
 *
 *
 * Input: n = 10, k = 100
 * Output: "abacbabacb"
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= n <= 10
 * 1 <= k <= 100
 *
 *
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {

    public String getHappyString(int n, int k) {
        Set<String> happyStringList = new HashSet<>();
        getHappyString(happyStringList, new StringBuilder(), n, '\0');
        List<String> happyString = new ArrayList<>(happyStringList);
        if (happyString.size() < k) {
            return "";
        }

        Collections.sort(happyString);
        return happyString.get(k - 1);
    }

    private void getHappyString(Set<String> happyStrings, StringBuilder currentString, int index, char lastChar) {
        if (index == 0) {
            happyStrings.add(currentString.toString());
        }
        else {
            if (lastChar == 'a') {
                appendCharAndRecur(happyStrings, currentString, index, 'b');
                appendCharAndRecur(happyStrings, currentString, index, 'c');
            } else if (lastChar == 'b') {
                appendCharAndRecur(happyStrings, currentString, index, 'a');
                appendCharAndRecur(happyStrings, currentString, index, 'c');
            } else if (lastChar == 'c') {
                appendCharAndRecur(happyStrings, currentString, index, 'a');
                appendCharAndRecur(happyStrings, currentString, index, 'b');
            } else {
                appendCharAndRecur(happyStrings, currentString, index, 'a');
                appendCharAndRecur(happyStrings, currentString, index, 'b');
                appendCharAndRecur(happyStrings, currentString, index, 'c');
            }
        }
    }

    private void appendCharAndRecur(Set<String> happyStrings, StringBuilder currentString, int index, char nextChar) {
        currentString.append(nextChar);
        getHappyString(happyStrings, currentString, index - 1, nextChar);
        currentString.deleteCharAt(currentString.length() - 1);
    }

}
// @lc code=end
