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

// @lc code=start
class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int palLength1 = buildPalindrome(s, i, i);
            int palLength2 = buildPalindrome(s, i, i + 1);
            if (palLength1 < palLength2) {
                if (end - start + 1 < palLength2) {
                    start = i - (palLength2 / 2 - 1);
                    end = i + 1 + (palLength2 / 2 - 1);
                }
            } else {
                if (end - start + 1 < palLength1) {
                    start = i - (palLength1 / 2);
                    end = i + (palLength1 / 2);
                }
            }
        }

        return s.substring(start, end + 1);
    }

    private int buildPalindrome(String s, int left, int right) {
        if (s.length() == right) {
            return 0;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return 1;
        }
        while (0 < left && right < s.length() - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
            left--;
            right++;
        }
        return right - left + 1;
    }

}
// @lc code=end
