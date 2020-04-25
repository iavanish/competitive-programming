/*
 * @lc app=leetcode id=1419 lang=java
 *
 * [1419] Minimum Number of Frogs Croaking
 *
 * https://leetcode.com/problems/minimum-number-of-frogs-croaking/description/
 *
 * algorithms
 * Medium (43.19%)
 * Likes:    182
 * Dislikes: 11
 * Total Accepted:    7.8K
 * Total Submissions: 18.1K
 * Testcase Example:  '"croakcroak"'
 *
 * Given the string croakOfFrogs, which represents a combination of the string
 * "croak" from different frogs, that is, multiple frogs can croak at the same
 * time, so multiple “croak” are mixed. Return the minimum number of different
 * frogs to finish all the croak in the given string.
 * 
 * A valid "croak" means a frog is printing 5 letters ‘c’, ’r’, ’o’, ’a’, ’k’
 * sequentially. The frogs have to print all five letters to finish a croak. If
 * the given string is not a combination of valid "croak" return -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: croakOfFrogs = "croakcroak"
 * Output: 1 
 * Explanation: One frog yelling "croak" twice.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: croakOfFrogs = "crcoakroak"
 * Output: 2 
 * Explanation: The minimum number of frogs is two. 
 * The first frog could yell "crcoakroak".
 * The second frog could yell later "crcoakroak".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: croakOfFrogs = "croakcrook"
 * Output: -1
 * Explanation: The given string is an invalid combination of "croak" from
 * different frogs.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: croakOfFrogs = "croakcroa"
 * Output: -1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= croakOfFrogs.length <= 10^5
 * All characters in the string are: 'c', 'r', 'o', 'a' or 'k'.
 * 
 */

// @lc code=start
class Solution {

    public int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();

        int[] count = new int[5];
        int minFrogs = 0;
        for (int i = n-1; i >= 0; i--) {
            int temp = charToInt(croakOfFrogs.charAt(i));
            if (temp != 4 && count[temp] == count[temp+1]) {
                return -1;
            }
            count[temp]++;
            minFrogs = Math.max(minFrogs, count[4]);
            if (temp == 0) {
                for (int j = 0; j < 5; j++) {
                    count[j]--;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (count[i] > 0) {
                return -1;
            }
        }

        return minFrogs;
    }

    private int charToInt(char c) {
        if (c == 'c') {
            return 0;
        }
        if (c == 'r') {
            return 1;
        }
        if (c == 'o') {
            return 2;
        }
        if (c == 'a') {
            return 3;
        }
        return 4;
    }

}
// @lc code=end
