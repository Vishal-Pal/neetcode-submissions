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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        } else if(l2 == null){
            return l1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode ptr1 = l1, ptr2 = l2, ptr = dummyHead;
        int sum=0, carry = 0;
        while(ptr1!=null || ptr2!=null || carry!=0){
            int val1 = ptr1 == null ? 0:ptr1.val;
            int val2 = ptr2 == null ? 0:ptr2.val;
            sum=val1+val2+carry;
            carry=sum/10;
            ptr.next = new ListNode(sum%10);
            ptr = ptr.next;
            ptr1 = ptr1 == null ? null:ptr1.next;
            ptr2 = ptr2 == null ? null:ptr2.next;
        }
        return dummyHead.next;
    }
}
