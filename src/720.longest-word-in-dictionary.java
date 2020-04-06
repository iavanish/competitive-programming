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

import java.util.Arrays;

// @lc code=start
class Solution {

    public String longestWord(String[] words) {
        TrieNode trie = new TrieNode();

        for (String w : words) {
            TrieNode temp = trie;
            for (int i = 0; i < w.length(); i++) {
                temp = temp.addChild(w.charAt(i));
            }
            temp.isLeaf = true;
        }

        String longestWord = "";
        for (String w : words) {
            TrieNode temp = trie;
            boolean allPrefixesPresent = true;
            for (int i = 0; i < w.length()-1 && allPrefixesPresent; i++) {
                temp = temp.getChild(w.charAt(i));
                if (temp == null || temp.count == 1 || !temp.isLeaf) {
                    allPrefixesPresent = false;
                }
            }
            if (allPrefixesPresent && (longestWord.length() < w.length() || (longestWord.length() == w.length() && w.compareTo(longestWord) < 0))) {
                longestWord = w;
            }
        }

        return longestWord;
    }

    private static class TrieNode {
        private TrieNode[] children;
        private int count;
        private boolean isLeaf;
        private TrieNode() {
            children = new TrieNode[26];
            count = 0;
            isLeaf = false;
        }
        private TrieNode addChild(char c) {
            if (getChild(c) == null) {
                children[getKey(c)] = new TrieNode();
            }
            children[getKey(c)].count++;
            return children[getKey(c)];
        }
        private TrieNode getChild(char c) {
            return children[getKey(c)];
        }
        private int getKey(char c) {
            return c - 'a';
        }
    }

}
// @lc code=end
