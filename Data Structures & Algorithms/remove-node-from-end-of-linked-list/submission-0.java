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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode forward = head;
        for(int i=0;i<n;i++){
            forward = forward.next;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead, curr = head;
        while(forward!=null){
            prev = curr;
            curr = curr.next;
            forward = forward.next;
        }
        prev.next = curr.next;
        return dummyHead.next; 
    }
}
