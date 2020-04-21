/*
 * @lc app=leetcode id=1079 lang=java
 *
 * [1079] Letter Tile Possibilities
 *
 * https://leetcode.com/problems/letter-tile-possibilities/description/
 *
 * algorithms
 * Medium (74.51%)
 * Likes:    400
 * Dislikes: 18
 * Total Accepted:    19.8K
 * Total Submissions: 26.5K
 * Testcase Example:  '"AAB"'
 *
 * You have a set of tiles, where each tile has one letter tiles[i] printed on
 * it.  Return the number of possible non-empty sequences of letters you can
 * make.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB",
 * "ABA", "BAA".
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "AAABBC"
 * Output: 188
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 * 
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {

    public int numTilePossibilities(String tiles) {
        Set<String> possibilities = new HashSet<>();
        for(int i = 1; i <= tiles.length(); i++) {
            generateAllPossibilities(tiles, new boolean[tiles.length()], possibilities, i, new StringBuilder());
        }
        return possibilities.size();
    }

    private void generateAllPossibilities(String tiles, boolean[] isPicked, Set<String> possibilities, int size, StringBuilder temp) {
        for(int i = 0; i < tiles.length(); i++) {
            if(!isPicked[i]) {
                temp.append(tiles.charAt(i));
                if(temp.length() == size) {
                    possibilities.add(temp.toString());
                }
                else {
                    isPicked[i] = true;
                    generateAllPossibilities(tiles, isPicked, possibilities, size, temp);
                    isPicked[i] = false;
                }
                temp.delete(temp.length()-1, temp.length());
            }
        }
    }

}
// @lc code=end
