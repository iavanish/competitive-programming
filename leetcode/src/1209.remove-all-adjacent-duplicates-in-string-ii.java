/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 *
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/
 *
 * algorithms
 * Medium (56.29%)
 * Likes:    453
 * Dislikes: 14
 * Total Accepted:    27.1K
 * Total Submissions: 48.3K
 * Testcase Example:  '"abcd"\n2'
 *
 * Given a string s, a k duplicate removal consists of choosing k adjacent and
 * equal letters from s and removing them causing the left and the right side
 * of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 *
 * It is guaranteed that the answer is unique.
 *
 *
 * Example 1:
 *
 *
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 *
 * Example 2:
 *
 *
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 *
 * Example 3:
 *
 *
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s only contains lower case English letters.
 *
 *
 */

import java.util.Stack;

// @lc code=start
class Solution {

    public String removeDuplicates(String s, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (charStack.isEmpty() || charStack.peek() != s.charAt(i)) {
                charStack.push(s.charAt(i));
                countStack.push(1);
            } else {
                countStack.push(countStack.pop() + 1);
                if (countStack.peek() == k) {
                    charStack.pop();
                    countStack.pop();
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!charStack.isEmpty()) {
            int n = countStack.pop();
            char c = charStack.pop();
            for (int i = 0; i < n; i++) {
                result.append(c);
            }
        }

        return result.reverse().toString();
    }

}
// @lc code=end
