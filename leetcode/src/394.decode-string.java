/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (47.50%)
 * Likes:    2495
 * Dislikes: 129
 * Total Accepted:    170.8K
 * Total Submissions: 354.5K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 *
 *
 *
 */

import java.util.Stack;

// @lc code=start
class Solution {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }
        return decodeString(stack);
    }

    private String decodeString(Stack<Character> stack) {
        if (stack.empty() || stack.peek() == ']') {
            return "";
        }
        if (stack.peek() >= '0' && stack.peek() <= '9') {
            StringBuilder rep = new StringBuilder(String.valueOf(stack.pop()));
            while (stack.peek() >= '0' && stack.peek() <= '9') {
                rep.append(stack.pop());
            }
            stack.pop();
            int repetition = Integer.parseInt(rep.toString());
            String temp = decodeString(stack);
            StringBuilder result = new StringBuilder();
            while (repetition-- > 0) {
                result.append(temp);
            }
            stack.pop();
            return result.append(decodeString(stack)).toString();
        }
        StringBuilder str = new StringBuilder(String.valueOf(stack.pop()));
        while (!stack.empty() && stack.peek() >= 'a' && stack.peek() <= 'z') {
            str.append(stack.pop());
        }
        if (!stack.empty() && stack.peek() != ']') {
            return str.append(decodeString(stack)).toString();
        }
        return str.toString();
    }

}
// @lc code=end
