/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (24.53%)
 * Likes:    717
 * Dislikes: 1103
 * Total Accepted:    160.8K
 * Total Submissions: 650.8K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar"
 * respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * Output: []
 * 
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        if(n == 0) {
            return new ArrayList<>();
        }
        int m = words[0].length();

        Map<String, Integer> wordMap = new HashMap<>();
        for(String w : words) {
            wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i + n*m <= s.length(); i++) {
            Map<String, Integer> tempWordMap = new HashMap<>(wordMap);
            boolean flag = true;
            for(int j = i; j < i + n*m; j += m) {
                String substring = s.substring(j, j + m);
                if(tempWordMap.containsKey(substring)) {
                    int c = tempWordMap.get(substring);
                    if(c == 1) {
                        tempWordMap.remove(substring);
                    }
                    else {
                        tempWordMap.put(substring, c-1);
                    }
                }
                else {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                result.add(i);
            }
        }

        return result;
    }

}
// @lc code=end
