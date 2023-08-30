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
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        //finding the mid
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        // if (head.next.next == null) {
        //     return head;
        // }
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = prev;
        ListNode rightHead = mid.next;
        mid.next = null;
        
        //calling merge sort recursively
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        
        //merging the two halves
        return merge (left, right);
    }
    
    public ListNode merge(ListNode left, ListNode right) {
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        
        
        return newHead.next;
    }
    
    
    
}