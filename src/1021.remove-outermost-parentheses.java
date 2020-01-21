/*
 * @lc app=leetcode id=1021 lang=java
 *
 * [1021] Remove Outermost Parentheses
 *
 * https://leetcode.com/problems/remove-outermost-parentheses/description/
 *
 * algorithms
 * Easy (76.06%)
 * Likes:    305
 * Dislikes: 440
 * Total Accepted:    64.9K
 * Total Submissions: 85K
 * Testcase Example:  '"(()())(())"'
 *
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B,
 * where A and B are valid parentheses strings, and + represents string
 * concatenation.  For example, "", "()", "(())()", and "(()(()))" are all
 * valid parentheses strings.
 * 
 * A valid parentheses string S is primitive if it is nonempty, and there does
 * not exist a way to split it into S = A+B, with A and B nonempty valid
 * parentheses strings.
 * 
 * Given a valid parentheses string S, consider its primitive decomposition: S
 * = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * 
 * Return S after removing the outermost parentheses of every primitive string
 * in the primitive decomposition of S.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation: 
 * The input string is "(()())(())", with primitive decomposition "(()())" +
 * "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" =
 * "()()()".
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation: 
 * The input string is "(()())(())(()(()))", with primitive decomposition
 * "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" +
 * "()(())" = "()()()()(())".
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "()()"
 * Output: ""
 * Explanation: 
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S.length <= 10000
 * S[i] is "(" or ")"
 * S is a valid parentheses string
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// @lc code=start
class Solution {

    public String removeOuterParentheses(String S) {
        List<String> temp = removeOuterParentheses(List.of(S));

        StringBuilder result = new StringBuilder();
        for(String i : temp) {
            if(i.length() > 2) {
                result.append(i.substring(1, i.length()-1));
            }
        }
        return result.toString();
    }

    private List<String> removeOuterParentheses(List<String> s) {
        List<String> result = new ArrayList<>();
        for(String i : s) {
            StringBuilder temp = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < i.length(); j++) {
                temp.append(i.charAt(j));
                if(i.charAt(j) == '(') {
                    stack.push('(');
                }
                else {
                    stack.pop();
                    if(stack.empty()) {
                        result.add(temp.toString());
                        temp = new StringBuilder();
                    }
                }
            }
        }
        return result;
    }

}
// @lc code=end
