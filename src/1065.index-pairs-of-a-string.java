/*
 * @lc app=leetcode id=1065 lang=java
 *
 * [1065] Index Pairs of a String
 *
 * https://leetcode.com/problems/index-pairs-of-a-string/description/
 *
 * algorithms
 * Easy (58.14%)
 * Likes:    51
 * Dislikes: 35
 * Total Accepted:    4.8K
 * Total Submissions: 8.1K
 * Testcase Example:  '"thestoryofleetcodeandme"\n["story","fleet","leetcode"]'
 *
 * Given a text string and words (a list of strings), return all index pairs
 * [i, j] so that the substring text[i]...text[j] is in the list of words.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text = "thestoryofleetcodeandme", words =
 * ["story","fleet","leetcode"]
 * Output: [[3,7],[9,13],[10,17]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text = "ababa", words = ["aba","ab"]
 * Output: [[0,1],[0,2],[2,3],[2,4]]
 * Explanation: 
 * Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All strings contains only lowercase English letters.
 * It's guaranteed that all strings in words are different.
 * 1 <= text.length <= 100
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 50
 * Return the pairs [i,j] in sorted order (i.e. sort them by their first
 * coordinate in case of ties sort them by their second coordinate).
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// @lc code=start
class Solution {

    public int[][] indexPairs(String text, String[] words) {
        List<int[]> indexPairs = new ArrayList<>();
        for(String w : words) {
            int index = text.indexOf(w);
            if(index >= 0) {
                indexPairs.add(new int[] {index, index+w.length()-1});
            }
            index = text.indexOf(w, index+1);
            while(index >= 0) {
                indexPairs.add(new int[] {index, index+w.length()-1});
                index = text.indexOf(w, index+1);
            }
        }

        Collections.sort(indexPairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t1[0] != t2[0]) {
                    return t1[0] - t2[0];
                }
                return t1[1] - t2[1];
            }
        });

        int[][] result = new int[indexPairs.size()][2];
        for(int i = 0; i < indexPairs.size(); i++) {
            result[i][0] = indexPairs.get(i)[0];
            result[i][1] = indexPairs.get(i)[1];
        }

        return result;
    }

}
// @lc code=end
