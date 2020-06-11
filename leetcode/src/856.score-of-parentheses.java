/*
 * @lc app=leetcode id=856 lang=java
 *
 * [856] Score of Parentheses
 *
 * https://leetcode.com/problems/score-of-parentheses/description/
 *
 * algorithms
 * Medium (58.51%)
 * Likes:    848
 * Dislikes: 30
 * Total Accepted:    30.1K
 * Total Submissions: 51K
 * Testcase Example:  '"()"'
 *
 * Given a balanced parentheses string S, compute the score of the string based
 * on the following rule:
 *
 *
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: "()"
 * Output: 1
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "(())"
 * Output: 2
 *
 *
 *
 * Example 3:
 *
 *
 * Input: "()()"
 * Output: 2
 *
 *
 *
 * Example 4:
 *
 *
 * Input: "(()(()))"
 * Output: 6
 *
 *
 *
 *
 * Note:
 *
 *
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 *
 *
 *
 *
 *
 *
 */

import java.util.Stack;

// @lc code=start
class Solution {

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < S.length()) {
            if (S.charAt(index) == '(' && S.charAt(index + 1) == ')') {
                index++;
                stack.push(1);
            } else if (S.charAt(index) == '(') {
                stack.push(-1);
            } else {
                int value = 0;
                while (stack.peek() >= 0) {
                    value += stack.pop();
                }
                stack.pop();
                stack.push(2 * value);
            }
            index++;
        }

        int result = stack.pop();
        while (!stack.empty()) {
            result += stack.pop();
        }

        return result;
    }

}
// @lc code=end
