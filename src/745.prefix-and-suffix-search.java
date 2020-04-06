/*
 * @lc app=leetcode id=745 lang=java
 *
 * [745] Prefix and Suffix Search
 *
 * https://leetcode.com/problems/prefix-and-suffix-search/description/
 *
 * algorithms
 * Hard (32.55%)
 * Likes:    286
 * Dislikes: 185
 * Total Accepted:    16.9K
 * Total Submissions: 50.9K
 * Testcase Example:  '["WordFilter","f"]\n[[["apple"]],["a","e"]]'
 *
 * Given many words, words[i] has weight i.
 * 
 * Design a class WordFilter that supports one function, WordFilter.f(String
 * prefix, String suffix). It will return the word with given prefix and suffix
 * with maximum weight. If no word exists, return -1.
 * 
 * Examples:
 * 
 * 
 * Input:
 * WordFilter(["apple"])
 * WordFilter.f("a", "e") // returns 0
 * WordFilter.f("b", "") // returns -1
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * words has length in range [1, 15000].
 * For each test case, up to words.length queries WordFilter.f may be made.
 * words[i] has length in range [1, 10].
 * prefix, suffix have lengths in range [0, 10].
 * words[i] and prefix, suffix queries consist of lowercase letters only.
 * 
 * 
 * 
 * 
 */

import java.util.LinkedHashSet;
import java.util.Set;

// @lc code=start
class WordFilter {

    private TrieNode prefixTrie;
    private TrieNode suffixTrie;

    public WordFilter(String[] words) {
        prefixTrie = new TrieNode();
        suffixTrie = new TrieNode();
        for (int i = words.length-1; i >= 0; i--) {
            TrieNode tempPrefix = prefixTrie;
            TrieNode tempSuffix = suffixTrie;
            tempPrefix.sortedWeightSet.add(i);
            tempSuffix.sortedWeightSet.add(i);
            for (int j = 0, k = words[i].length()-1; j < words[i].length(); j++, k--) {
                tempPrefix = tempPrefix.addChild(words[i].charAt(j), i);
                tempSuffix = tempSuffix.addChild(words[i].charAt(k), i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode tempPrefix = prefixTrie;
        TrieNode tempSuffix = suffixTrie;
        for (int i = 0; i < prefix.length() && tempPrefix != null; i++) {
            tempPrefix = tempPrefix.getChild(prefix.charAt(i));
        }
        if (tempPrefix == null) {
            return -1;
        }
        for (int i = suffix.length()-1; i >= 0 && tempSuffix != null; i--) {
            tempSuffix = tempSuffix.getChild(suffix.charAt(i));
        }
        if (tempSuffix == null) {
            return -1;
        }
        for (Integer i : tempPrefix.sortedWeightSet) {
            if (tempSuffix.sortedWeightSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    private static class TrieNode {
        private TrieNode[] children;
        private Set<Integer> sortedWeightSet;
        public TrieNode() {
            children = new TrieNode[26];
            sortedWeightSet = new LinkedHashSet<>();
        }
        private TrieNode addChild(char c, int weight) {
            if (children[getKey(c)] == null) {
                children[getKey(c)] = new TrieNode();
            }
            children[getKey(c)].sortedWeightSet.add(weight);
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

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
// @lc code=end
