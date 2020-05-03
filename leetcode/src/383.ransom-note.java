/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 *
 * https://leetcode.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (51.79%)
 * Likes:    518
 * Dislikes: 181
 * Total Accepted:    170.7K
 * Total Submissions: 322.9K
 * Testcase Example:  '"a"\n"b"'
 *
 *
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the
 * ransom
 * note can be constructed from the magazines ; otherwise, it will return
 * false.
 *
 *
 * Each letter in the magazine string can only be used once in your ransom
 * note.
 *
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 *
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 *
 */

// @lc code=start
class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineSet = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            magazineSet[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int remaining = --magazineSet[ransomNote.charAt(i) - 'a'];
            if (remaining < 0) {
                return false;
            }
        }

        return true;
    }

}
// @lc code=end
