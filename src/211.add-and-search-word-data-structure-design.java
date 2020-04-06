/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (33.25%)
 * Likes:    1416
 * Dislikes: 75
 * Total Accepted:    160K
 * Total Submissions: 462K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n' +
  '[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one
 * letter.
 * 
 * Example:
 * 
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 */

// @lc code=start
class WordDictionary {

    private TrieNode trie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp = trie;
        for (int i = 0; i < word.length(); i++) {
            temp = temp.addChild(word.charAt(i));
        }
        temp.isLeaf = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(trie, word, 0);
    }

    private boolean search(TrieNode trie, String word, int index) {
        if (word.length() == index) {
            return trie != null && trie.isLeaf;
        }
        else if (trie == null) {
            return false;
        }
        else if (word.charAt(index) != '.') {
            return search(trie.getChild(word.charAt(index)), word, index+1);
        }
        for (int i = 0; i < 26; i++) {
            if (trie.getChild(i) != null && search(trie.getChild(i), word, index+1)) {
                return true;
            }
        }
        return false;
    }

    private static class TrieNode {
        private TrieNode[] children;
        private boolean isLeaf;
        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
        }
        private TrieNode addChild(char c) {
            if (children[getKey(c)] == null) {
                children[getKey(c)] = new TrieNode();
            }
            return children[getKey(c)];
        }
        private TrieNode getChild(char c) {
            return children[getKey(c)];
        }
        private TrieNode getChild(int c) {
            return children[c];
        }
        private int getKey(char c) {
            return c - 'a';
        }
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end
