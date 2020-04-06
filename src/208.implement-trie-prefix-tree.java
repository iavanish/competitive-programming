/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (42.67%)
 * Likes:    2496
 * Dislikes: 44
 * Total Accepted:    252.1K
 * Total Submissions: 565.8K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Example:
 * 
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 * 
 * 
 */

// @lc code=start
class Trie {

    private TrieNode trie;

    /** Initialize your data structure here. */
    public Trie() {
        trie = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = trie;
        for (int i = 0; i < word.length(); i++) {
            temp = temp.insert(word.charAt(i));
        }
        temp.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = traverseTrie(word);
        return temp != null && temp.isLeaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = traverseTrie(prefix);
        return temp != null;
    }

    private TrieNode traverseTrie(String word) {
        TrieNode temp = trie;
        for (int i = 0; i < word.length() && temp != null; i++) {
            temp = temp.getChild(word.charAt(i));
        }
        return temp;
    }

    private static class TrieNode {
        public TrieNode[] children;
        public boolean isLeaf;
        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
        }
        public TrieNode insert(char c) {
            if (getChild(c) == null) {
                children[getKey(c)] = new TrieNode();
            }
            return getChild(c);
        }
        public TrieNode getChild(char c) {
            return children[getKey(c)];
        }
        private int getKey(char c) {
            return c - 'a';
        }
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
