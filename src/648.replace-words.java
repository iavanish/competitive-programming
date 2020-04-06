/*
 * @lc app=leetcode id=648 lang=java
 *
 * [648] Replace Words
 *
 * https://leetcode.com/problems/replace-words/description/
 *
 * algorithms
 * Medium (54.22%)
 * Likes:    600
 * Dislikes: 125
 * Total Accepted:    48.5K
 * Total Submissions: 87.8K
 * Testcase Example:  '["cat", "bat", "rat"]\n"the cattle was rattled by the battery"'
 *
 * In English, we have a concept called root, which can be followed by some
 * other words to form another longer word - let's call this word successor.
 * For example, the root an, followed by other, which can form another word
 * another.
 * 
 * Now, given a dictionary consisting of many roots and a sentence. You need to
 * replace all the successor in the sentence with the root forming it. If a
 * successor has many roots can form it, replace it with the root with the
 * shortest length.
 * 
 * You need to output the sentence after the replacement.
 * 
 * Example 1:
 * 
 * 
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 * 
 * 
 * 
 * 
 */

import java.util.List;

// @lc code=start
class Solution {

    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.isEmpty() || sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        TrieNode trie = new TrieNode();
        for (String d : dict) {
            TrieNode temp = trie;
            for (int i = 0; i < d.length(); i++) {
                temp = temp.addChild(d.charAt(i));
            }
            temp.isLeaf = true;
        }

        String[] tokenizedString = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tokenizedString.length; i++) {
            int j = 0;
            TrieNode temp = trie;
            while (j < tokenizedString[i].length() && temp != null && !temp.isLeaf) {
                temp = temp.getChild(tokenizedString[i].charAt(j));
                j++;
            }
            if (temp != null && temp.isLeaf) {
                result.append(tokenizedString[i], 0, j);
            }
            else {
                result.append(tokenizedString[i]);
            }
            if (i != tokenizedString.length-1) {
                result.append(' ');
            }
        }

        return result.toString();
    }

    private static class TrieNode {
        public TrieNode[] children;
        public boolean isLeaf;
        public TrieNode() {
            this.children = new TrieNode[26];
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
        private int getKey(char c) {
            return c - 'a';
        }
    }

}
// @lc code=end
