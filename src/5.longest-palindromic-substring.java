/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (28.48%)
 * Likes:    5120
 * Dislikes: 447
 * Total Accepted:    758K
 * Total Submissions: 2.7M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */

import java.util.Arrays;

// @lc code=start
class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        boolean[][] isPalindrome = new boolean[n][n];
        Arrays.fill(isPalindrome[0], true);

        for (int i = 1; i < n; i++) {
            isPalindrome[1][i] = s.charAt(i-1) == s.charAt(i);
        }

        for (int i = 2; i < n; i++) {
            for (int j = i; j < n; j++) {
                isPalindrome[i][j] = isPalindrome[i-2][j-1] && s.charAt(j-i) == s.charAt(j);
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (isPalindrome[i][j]) {
                    return s.substring(j-i, j+1);
                }
            }
        }

        return "";
    }

}
// @lc code=end
