/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 *
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (38.96%)
 * Likes:    1737
 * Dislikes: 337
 * Total Accepted:    236.7K
 * Total Submissions: 596.7K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the
 * linked list. If the number of nodes is not a multiple of k then left-out
 * nodes in the end should remain as it is.
 *
 *
 *
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be
 * changed.
 *
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        int count = 0;
        ListNode curr = head;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (count < k) {
            return head;
        }

        ListNode[] result = reverseLinkedList(head, null, k);
        head.next = reverseKGroup(result[1], k);
        return result[0];
    }

    private ListNode[] reverseLinkedList(ListNode head, ListNode prev, int k) {
        if (k == 0) {
            return new ListNode[]{prev, head};
        }
        ListNode next = head.next;
        head.next = prev;
        return reverseLinkedList(next, head, k - 1);
    }

}
// @lc code=end
