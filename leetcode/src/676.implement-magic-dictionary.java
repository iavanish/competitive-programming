/*
 * @lc app=leetcode id=676 lang=java
 *
 * [676] Implement Magic Dictionary
 *
 * https://leetcode.com/problems/implement-magic-dictionary/description/
 *
 * algorithms
 * Medium (52.71%)
 * Likes:    501
 * Dislikes: 116
 * Total Accepted:    34.5K
 * Total Submissions: 64.8K
 * Testcase Example:  '["MagicDictionary", "buildDict", "search", "search", "search", "search"]\n' +
  '[[], [["hello","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]'
 *
 * 
 * Implement a magic directory with buildDict, and search methods.
 * 
 * 
 * 
 * For the method buildDict, you'll be given a list of non-repetitive words to
 * build a dictionary.
 * 
 * 
 * 
 * For the method search, you'll be given a word, and judge whether if you
 * modify exactly one character into another character in this word, the
 * modified word is in the dictionary you just built.
 * 
 * 
 * Example 1:
 * 
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * 
 * 
 * 
 * Note:
 * 
 * You may assume that all the inputs are consist of lowercase letters a-z.
 * For contest purpose, the test data is rather small by now. You could think
 * about highly efficient algorithm after the contest.
 * Please remember to RESET your class variables declared in class
 * MagicDictionary, as static/class variables are persisted across multiple
 * test cases. Please see here for more details.
 * 
 * 
 */

// @lc code=start
class MagicDictionary {

    private TrieNode trie;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        trie = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String d : dict) {
            TrieNode temp = trie;
            for (int i = 0; i < d.length(); i++) {
                temp = temp.addChild(d.charAt(i));
            }
            temp.isLeaf = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return search(trie, word, 0, false);
    }

    private boolean search(TrieNode trie, String word, int index, boolean isModified) {
        if (index == word.length()) {
            return isModified && trie.isLeaf;
        }
        if (trie.getChild(word.charAt(index)) != null) {
            if (search(trie.getChild(word.charAt(index)), word, index+1, isModified)) {
                return true;
            }
        }
        if (isModified) {
            return false;
        }
        for (int i = 0; i < 26; i++) {
            if (i != word.charAt(index) - 'a' && trie.getChild(i) != null) {
                if (search(trie.getChild(i), word, index+1, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class TrieNode {
        public TrieNode[] children;
        public boolean isLeaf;
        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
        }
        private TrieNode addChild(char c) {
            if (getChild(c) == null) {
                children[getKey(c)] = new TrieNode();
            }
            return getChild(c);
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
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end
