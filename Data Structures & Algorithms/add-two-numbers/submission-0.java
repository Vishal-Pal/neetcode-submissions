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
        while(ptr1!=null && ptr2!=null){
            sum=ptr1.val+ptr2.val+carry;
            carry=sum/10;
            ptr.next = new ListNode(sum%10);
            ptr = ptr.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while(ptr1!=null){
            sum=ptr1.val+carry;
            carry=sum/10;
            ptr.next = new ListNode(sum%10);
            ptr = ptr.next;
            ptr1 = ptr1.next;
        }
        while(ptr2!=null){
            sum=ptr2.val+carry;
            carry=sum/10;
            ptr.next = new ListNode(sum%10);
            ptr = ptr.next;
            ptr2 = ptr2.next;
        }
        if(carry!=0){
            ptr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
