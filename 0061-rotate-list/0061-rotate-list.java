/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        
        k = k % size;
        
        if (k == 0) {
            return head;
        }
        
        
        int counter = size;
        temp = head;
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode tail = null;
        
        while (temp != null) {
            if (counter == k+1) {
                newTail = temp;
                newHead = temp.next;
            }
            tail = temp;
            temp = temp.next;
            counter--;
        }
        
        newTail.next = null;
        tail.next = head;
        head = newHead;
        
        return newHead;
    }
}