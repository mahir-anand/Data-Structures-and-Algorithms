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
    public void reorderList(ListNode head) {
        
        if (head == null || head.next == null) {
            return;
        }
        
        //find mid
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        //reverse second half
        ListNode curr = slow;
        prev = null;
        ListNode next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        //reorder LL
        ListNode firstHead = head;
        ListNode secondHead = prev;
        while (firstHead != null) {
            ListNode temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;
            if (firstHead == null) {
                break;   
            }
            ListNode temp2 = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp2;
        }
        
        // if (firstHead != null) {
        //     firstHead.next = null;
        // }
    }
}