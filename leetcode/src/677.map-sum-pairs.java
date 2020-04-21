/*
 * @lc app=leetcode id=677 lang=java
 *
 * [677] Map Sum Pairs
 *
 * https://leetcode.com/problems/map-sum-pairs/description/
 *
 * algorithms
 * Medium (52.52%)
 * Likes:    417
 * Dislikes: 71
 * Total Accepted:    35.9K
 * Total Submissions: 67.7K
 * Testcase Example:  '["MapSum", "insert", "sum", "insert", "sum"]\n' +
  '[[], ["apple",3], ["ap"], ["app",2], ["ap"]]'
 *
 * 
 * Implement a MapSum class with insert, and sum methods.
 * 
 * 
 * 
 * For the method insert, you'll be given a pair of (string, integer). The
 * string represents the key and the integer represents the value. If the key
 * already existed, then the original key-value pair will be overridden to the
 * new one.
 * 
 * 
 * 
 * For the method sum, you'll be given a string representing the prefix, and
 * you need to return the sum of all the pairs' value whose key starts with the
 * prefix.
 * 
 * 
 * Example 1:
 * 
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 * 
 * 
 * 
 */

// @lc code=start
class MapSum {

    private TrieNode trie;

    /** Initialize your data structure here. */
    public MapSum() {
        trie = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode temp = trie;
        for (int i = 0; i < key.length(); i++) {
            temp = temp.addChild(key.charAt(i), val);
        }
        if (temp.isLeaf) {
            int tempCurrNodeValue = temp.currNodeValue;
            temp = trie;
            for (int i = 0; i < key.length(); i++) {
                temp = temp.getChild(key.charAt(i));
                temp.value -= tempCurrNodeValue;
            }
        }
        temp.isLeaf = true;
        temp.currNodeValue = val;
    }
    
    public int sum(String prefix) {
        int i = 0;
        TrieNode temp = trie;
        while (i < prefix.length() && temp != null) {
            temp = temp.getChild(prefix.charAt(i++));
        }
        if (temp == null) {
            return 0;
        }
        return temp.value;
    }

    private static class TrieNode {
        public TrieNode[] children;
        public boolean isLeaf;
        public int currNodeValue;
        public int value;
        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
            currNodeValue = 0;
            value = 0;
        }
        private TrieNode addChild(char c, int value) {
            if (getChild(c) == null) {
                children[getKey(c)] = new TrieNode();
            }
            children[getKey(c)].value += value;
            return getChild(c);
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
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end
