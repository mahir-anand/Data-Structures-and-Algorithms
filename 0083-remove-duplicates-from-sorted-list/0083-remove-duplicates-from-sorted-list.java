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
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null) {
            return head;
        }
        
        ListNode node = head;
        ListNode temp = head;
        ListNode itr = temp.next;

        while (itr != null) {
            if (temp.val == itr.val) {
                itr = itr.next;
            } else {
                temp.next = itr;
                temp = itr;
                itr = itr.next;
            }
        }
        
        temp.next = null;
        return node;
    }
}