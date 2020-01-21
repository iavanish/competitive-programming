/*
 * @lc app=leetcode id=709 lang=java
 *
 * [709] To Lower Case
 *
 * https://leetcode.com/problems/to-lower-case/description/
 *
 * algorithms
 * Easy (78.21%)
 * Likes:    388
 * Dislikes: 1304
 * Total Accepted:    175K
 * Total Submissions: 223.4K
 * Testcase Example:  '"Hello"'
 *
 * Implement function ToLowerCase() that has a string parameter str, and
 * returns the same string in lowercase.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "Hello"
 * Output: "hello"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "here"
 * Output: "here"
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "LOVELY"
 * Output: "lovely"
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {

    public String toLowerCase(String str) {
        StringBuilder lowerCase = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                lowerCase.append((char) (str.charAt(i) + 32));
            }
            else {
                lowerCase.append(str.charAt(i));
            }
        }

        return lowerCase.toString();
    }

}
// @lc code=end
