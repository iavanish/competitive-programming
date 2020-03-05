/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (38.65%)
 * Likes:    2168
 * Dislikes: 110
 * Total Accepted:    234.5K
 * Total Submissions: 592.6K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * 
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Queue<ListNode> queue = new LinkedList<>();
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            queue.add(temp);
        }

        while (queue.size() > 1) {
            queue.add(mergeLists(queue.poll(), queue.poll()));
        }
        return queue.poll();
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp;
        if (l1.val <= l2.val) {
            temp = l1;
            l1 = l1.next;
        }
        else {
            temp = l2;
            l2 = l2.next;
        }
        ListNode mergedList = temp;
        ListNode trav = temp;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            }
            else {
                temp = l2;
                l2 = l2.next;
            }
            trav.next = temp;
            trav = temp;
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
