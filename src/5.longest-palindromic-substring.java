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
        int maxLengthPal = n;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j+maxLengthPal-1 < n; j++) {
                if (isPalindrome(s, j, j+maxLengthPal-1)) {
                    return s.substring(j, j+maxLengthPal);
                }
            }
            maxLengthPal--;
        }
        return "";
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
// @lc code=end
