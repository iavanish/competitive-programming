/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (37.58%)
 * Likes:    2466
 * Dislikes: 321
 * Total Accepted:    357.4K
 * Total Submissions: 939.9K
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        return isPalindrome(head, head) != null;
    }

    private ListNode isPalindrome(ListNode head, ListNode tail) {
        if (tail.next != null) {
            ListNode temp = isPalindrome(head, tail.next);
            if (temp == null) {
                return null;
            }
            return temp.val != tail.val ? null : (temp.next != null ? temp.next : temp);
        }
        return head.val != tail.val ? null : (head.next != null ? head.next : head);
    }

}
// @lc code=end
