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
        if(head == null || head.next == null){
            return;
        }
        
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next; // Store second half head
        slow.next = null; // Disconnect first half from second half
        // Reverse second half
        ListNode prev = second, curr = second.next, next2 = null;
        while(curr!=null){
            next2 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next2;
        }
        second.next = null;
        second = prev;
        // Merge both halves
        ListNode first = head, next1 = head.next;
        while(first!=null && second!=null){
            next1 = first.next;
            next2 = second.next;
            first.next = second;
            second.next = next1;
            first = next1;
            second = next2;
        }
    }
}
