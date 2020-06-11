/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (34.67%)
 * Likes:    2666
 * Dislikes: 194
 * Total Accepted:    535.6K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 *
 * Example:
 *
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 *
 *
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 */

// @lc code=start

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return n != 1 ? head : null;
        }

        int depth = removeNthFromEndRecursively(head, n);
        if (depth == n) {
            return head.next;
        }
        return head;
    }

    private int removeNthFromEndRecursively(ListNode head, int n) {
        if (head.next == null) {
            return 1;
        }
        int depth = removeNthFromEndRecursively(head.next, n);
        if (depth == n) {
            head.next = head.next.next;
        }
        return depth + 1;
    }

}
// @lc code=end
