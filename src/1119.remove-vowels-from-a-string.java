/*
 * @lc app=leetcode id=1119 lang=java
 *
 * [1119] Remove Vowels from a String
 *
 * https://leetcode.com/problems/remove-vowels-from-a-string/description/
 *
 * algorithms
 * Easy (88.38%)
 * Likes:    51
 * Dislikes: 63
 * Total Accepted:    22K
 * Total Submissions: 24.8K
 * Testcase Example:  '"leetcodeisacommunityforcoders"'
 *
 * Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and
 * return the new string.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "leetcodeisacommunityforcoders"
 * Output: "ltcdscmmntyfrcdrs"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "aeiou"
 * Output: ""
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S consists of lowercase English letters only.
 * 1 <= S.length <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {

    public String removeVowels(String S) {
        return S.replaceAll("a", "").replaceAll("e", "")
                .replaceAll("i", "").replaceAll("o", "")
                .replaceAll("u", "");
    }

}
// @lc code=end
