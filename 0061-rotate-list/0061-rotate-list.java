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
        while (counter > k) {
            if (counter == k+1) {
                newHead = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
            counter--;
        }
        
        temp = newHead;
        ListNode tail = temp;
        while (temp != null) {
            tail = temp;
            temp = temp.next;
        }
        
        tail.next = head;
        head = newHead;
        
        return newHead;
    }
}