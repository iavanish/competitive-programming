/*
 * @lc app=leetcode id=720 lang=java
 *
 * [720] Longest Word in Dictionary
 *
 * https://leetcode.com/problems/longest-word-in-dictionary/description/
 *
 * algorithms
 * Easy (46.61%)
 * Likes:    514
 * Dislikes: 646
 * Total Accepted:    54K
 * Total Submissions: 113.9K
 * Testcase Example:  '["w","wo","wor","worl","world"]'
 *
 * Given a list of strings words representing an English Dictionary, find the
 * longest word in words that can be built one character at a time by other
 * words in words.  If there is more than one possible answer, return the
 * longest word with the smallest lexicographical order.  If there is no
 * answer, return the empty string.
 * 
 * Example 1:
 * 
 * Input: 
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation: 
 * The word "world" can be built one character at a time by "w", "wo", "wor",
 * and "worl".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation: 
 * Both "apply" and "apple" can be built from other words in the dictionary.
 * However, "apple" is lexicographically smaller than "apply".
 * 
 * 
 * 
 * Note:
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 * 
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {

    public String longestWord(String[] words) {
        Set<String> dictionary = new HashSet<>();
        for (String w : words) {
            dictionary.add(w);
        }

        String longestWord = "";
        for (String w : words) {
            boolean allPrefixesPresent = true;
            for (int i = 1; i < w.length() && allPrefixesPresent; i++) {
                if (!dictionary.contains(w.substring(0, i))) {
                    allPrefixesPresent = false;
                }
            }
            if (allPrefixesPresent && (longestWord.length() < w.length() || (longestWord.length() == w.length() && w.compareTo(longestWord) < 0))) {
                longestWord = w;
            }
        }

        return longestWord;
    }

}
// @lc code=end
