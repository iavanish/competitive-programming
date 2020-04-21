/*
 * @lc app=leetcode id=707 lang=java
 *
 * [707] Design Linked List
 *
 * https://leetcode.com/problems/design-linked-list/description/
 *
 * algorithms
 * Medium (21.50%)
 * Likes:    441
 * Dislikes: 598
 * Total Accepted:    44.4K
 * Total Submissions: 200K
 * Testcase Example:  '["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]\r\n' +
  '[[],[1],[3],[1,2],[1],[1],[1]]\r'
 *
 * Design your implementation of the linked list. You can choose to use the
 * singly linked list or the doubly linked list. A node in a singly linked list
 * should have two attributes: val and next. val is the value of the current
 * node, and next is a pointer/reference to the next node. If you want to use
 * the doubly linked list, you will need one more attribute prev to indicate
 * the previous node in the linked list. Assume all nodes in the linked list
 * are 0-indexed.
 * 
 * Implement these functions in your linked list class:
 * 
 * 
 * get(index) : Get the value of the index-th node in the linked list. If the
 * index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the
 * linked list. After the insertion, the new node will be the first node of the
 * linked list.
 * addAtTail(val) : Append a node of value val to the last element of the
 * linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in
 * the linked list. If index equals to the length of linked list, the node will
 * be appended to the end of linked list. If index is greater than the length,
 * the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the
 * index is valid.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * 
 * ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
 * [[],[1],[3],[1,2],[1],[1],[1]]
 * Output:  
 * [null,null,null,null,2,null,3]
 * 
 * Explanation:
 * MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= index,val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex
 * and deleteAtIndex.
 * 
 * 
 */

// @lc code=start
class MyLinkedList {

    private LinkedListNode head;
    private LinkedListNode tail;
    private int size;

    private static class LinkedListNode {
        public int val;
        public LinkedListNode next;
        public LinkedListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || size <= index) {
            return -1;
        }
        LinkedListNode trav = head;
        while (index-- > 0) {
            trav = trav.next;
        }
        return trav.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        LinkedListNode head = new LinkedListNode(val);
        head.next = this.head;
        this.head = head;
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        LinkedListNode tail = new LinkedListNode(val);
        if (this.tail != null) {
            this.tail.next = tail;
        }
        this.tail = tail;
        if (head == null) {
            head = tail;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        }
        else if (index == size) {
            addAtTail(val);
        }
        else if (0 < index && index < size) {
            LinkedListNode prev = null;
            LinkedListNode trav = head;
            while (index-- > 0) {
                prev = trav;
                trav = trav.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            prev.next = node;
            node.next = trav;
            size++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (0 <= index && index < size) {
            if (index == 0) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
            }
            else {
                LinkedListNode prev = null;
                LinkedListNode trav = head;
                while (index-- > 0) {
                    prev = trav;
                    trav = trav.next;
                }
                prev.next = trav.next;
                if (prev.next == null) {
                    tail = prev;
                }
            }
            size--;
        }
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end
