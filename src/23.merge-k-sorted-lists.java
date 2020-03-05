/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (37.46%)
 * Likes:    3824
 * Dislikes: 250
 * Total Accepted:    557.6K
 * Total Submissions: 1.5M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * 
 * 
 */

// @lc code=start

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>((l1, l2) -> l1.val - l2.val);
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }

        ListNode head = null;
        ListNode trav = null;
        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
            if (head == null) {
                head = node;
                trav = node;
            }
            else {
                trav.next = node;
                trav = trav.next;
            }
        }

        return head;
    }

}
// @lc code=end
