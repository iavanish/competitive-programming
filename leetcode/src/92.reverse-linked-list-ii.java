/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (36.82%)
 * Likes:    1846
 * Dislikes: 121
 * Total Accepted:    243.3K
 * Total Submissions: 652.1K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n <= m) {
            return head;
        }

        int i = 1;
        ListNode prevPrev = null;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null && i++ < m) {
            prevPrev = prev;
            prev = curr;
            curr = curr.next;
        }
        i--;

        while (curr != null && i++ < n) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        if (m == 1) {
            head.next = curr;
            return prev;
        }
        prevPrev.next.next = curr;
        prevPrev.next = prev;
        return head;
    }

}
// @lc code=end
