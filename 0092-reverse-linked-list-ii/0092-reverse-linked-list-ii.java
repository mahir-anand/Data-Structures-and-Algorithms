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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (head == null || left == right) {
            return head;
        }
        
        ListNode current = head;
        ListNode prev = null;
        ListNode next;
        
        int i = 1;
        
        while (i < left) {
            prev = current;
            current = current.next;
            i++;
        }
        
        ListNode first = current;
        ListNode last = prev;
        prev = null;
        
        while (i <= right) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        
        if (last != null) {
            last.next = prev;    
        } else {
            head = prev;
        }
        
        first.next = current;
        
        
        return head;
    }
}