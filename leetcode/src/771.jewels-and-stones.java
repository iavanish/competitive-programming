/*
 * @lc app=leetcode id=771 lang=java
 *
 * [771] Jewels and Stones
 *
 * https://leetcode.com/problems/jewels-and-stones/description/
 *
 * algorithms
 * Easy (84.25%)
 * Likes:    1752
 * Dislikes: 320
 * Total Accepted:    373.7K
 * Total Submissions: 443K
 * Testcase Example:  '"aA"\n"aAAbbbb"'
 *
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have.  Each character in S is a type of stone
 * you have.  You want to know how many of the stones you have are also
 * jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type
 * of stone from "A".
 *
 * Example 1:
 *
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 *
 * Example 2:
 *
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 *
 *
 * Note:
 *
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *
 *
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {

    public int numJewelsInStones(String J, String S) {
        Set<Character> isJewel = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            isJewel.add(J.charAt(i));
        }

        int numJewelsInStones = 0;
        for (int i = 0; i < S.length(); i++) {
            if (isJewel.contains(S.charAt(i))) {
                numJewelsInStones++;
            }
        }

        return numJewelsInStones;
    }

}
// @lc code=end
