/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (51.90%)
 * Likes:    1740
 * Dislikes: 112
 * Total Accepted:    491.6K
 * Total Submissions: 927.7K
 * Testcase Example:  '"leetcode"'
 *
 *
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 *
 *
 *
 * Note: You may assume the string contain only lowercase letters.
 *
 */

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// @lc code=start
class Solution {

    public int firstUniqChar(String s) {
        Set<Character> nonUniqueSet = new HashSet<>();
        Map<Character, Integer> uniqueMap = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!nonUniqueSet.contains(s.charAt(i)) && !uniqueMap.containsKey(s.charAt(i))) {
                uniqueMap.put(s.charAt(i), i);
            }
            else {
                uniqueMap.remove(s.charAt(i));
                nonUniqueSet.add(s.charAt(i));
            }
        }

        return !uniqueMap.isEmpty() ? uniqueMap.entrySet().iterator().next().getValue() : -1;
    }

}
// @lc code=end
