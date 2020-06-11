/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (52.26%)
 * Likes:    1098
 * Dislikes: 139
 * Total Accepted:    131.9K
 * Total Submissions: 249.5K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 *
 *
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 *
 *
 */

// @lc code=start

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = l2;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        ListNode result = addTwoNumbers(l1, stack);
        while (!stack.empty()) {
            temp = new ListNode(stack.pop());
            temp.next = result;
            if (result.val >= 10) {
                temp.val += result.val / 10;
                result.val %= 10;
            }
            result = temp;
        }
        if (result.val >= 10) {
            temp = new ListNode(result.val / 10);
            result.val %= 10;
            temp.next = result;
            result = temp;
        }
        return result;
    }

    private ListNode addTwoNumbers(ListNode l, Stack<Integer> stack) {
        ListNode next = null;
        if (l.next != null) {
            next = addTwoNumbers(l.next, stack);
        }
        ListNode curr = new ListNode(l.val + (!stack.empty() ? stack.pop() : 0) + (next != null ? next.val / 10 : 0));
        if (next != null) {
            next.val %= 10;
        }
        curr.next = next;
        return curr;
    }

}
// @lc code=end
