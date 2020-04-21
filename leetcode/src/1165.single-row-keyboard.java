/*
 * @lc app=leetcode id=1165 lang=java
 *
 * [1165] Single-Row Keyboard
 *
 * https://leetcode.com/problems/single-row-keyboard/description/
 *
 * algorithms
 * Easy (84.27%)
 * Likes:    100
 * Dislikes: 8
 * Total Accepted:    15.9K
 * Total Submissions: 18.9K
 * Testcase Example:  '"abcdefghijklmnopqrstuvwxyz"\n"cba"'
 *
 * There is a special keyboard with all keys in a single row.
 * 
 * Given a string keyboard of length 26 indicating the layout of the keyboard
 * (indexed from 0 to 25), initially your finger is at index 0. To type a
 * character, you have to move your finger to the index of the desired
 * character. The time taken to move your finger from index i to index j is |i
 * - j|.
 * 
 * You want to type a string word. Write a function to calculate how much time
 * it takes to type it with one finger.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
 * Output: 4
 * Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b'
 * then to 0 again to write 'a'.
 * Total time = 2 + 1 + 1 = 4. 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
 * Output: 73
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * keyboard.length == 26
 * keyboard contains each English lowercase letter exactly once in some
 * order.
 * 1 <= word.length <= 10^4
 * word[i] is an English lowercase letter.
 * 
 * 
 */

// @lc code=start
class Solution {

    public int calculateTime(String keyboard, String word) {
        int[] positions = new int[26];
        for(int i = 0; i < keyboard.length(); i++) {
            positions[keyboard.charAt(i) - 'a'] = i;
        }

        int time = 0;
        int lastPosition = 0;
        for(int i = 0; i < word.length(); i++) {
            int position = positions[word.charAt(i) - 'a'];
            time += Math.abs(lastPosition - position);
            lastPosition = position;
        }

        return time;
    }

}
// @lc code=end
