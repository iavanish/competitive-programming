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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        Queue<ListNode> queue = new LinkedList<>();
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        if (queue.isEmpty()) {
            return null;
        }

        while (queue.size() > 1) {
            queue.add(merge2Lists(queue.poll(), queue.poll()));
        }
        return queue.poll();
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode mergedList = null;
        ListNode trav = null;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val <= l2.val) {
                node = l1;
                l1 = l1.next;
            }
            else {
                node = l2;
                l2 = l2.next;
            }
            if (mergedList == null) {
                mergedList = node;
            }
            else {
                trav.next = node;
            }
            trav = node;
        }
        if (l1 != null) {
            trav.next = l1;
        }
        if (l2 != null) {
            trav.next = l2;
        }
        return mergedList;
    }

}
// @lc code=end
