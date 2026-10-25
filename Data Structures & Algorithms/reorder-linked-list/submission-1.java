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
        if(head == null){
            return;
        }
        // Find head of second half
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half
        ListNode ptr = slow.next, prev = null;
        slow.next = null; // Separate first and second half
        while(ptr!=null){
            ListNode next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        // Reorder list
        ListNode ptr1 = head, ptr2 = prev;
        while(ptr1!=null && ptr2!=null){
            ListNode next1 = ptr1.next;
            ListNode next2 = ptr2.next;
            ptr1.next = ptr2;
            ptr2.next = next1;
            ptr1 = next1;
            ptr2 = next2;
        }
    }
}

/***

We need to reverse the second half
So that we can have the reference to the previous pointer in the next pointer

First we'll need to find the head of the second half
For that we can use a slow and a fast pointer


How to reverse the second half?

0->1->2->3-4->x
1->0
prev = 1
ptr = 2 -> 1
prev = 2 
next = 3

[2,4,6,8]
     ^
         ^

[2,4]

[6,8]=>[8,6]

[2,4]

[8,6]

[2,8,4,6]

ptr1 = 2, ptr2 = 8, next1 = 4, next2 = 6


[2,4,6,8,10]
     ^
            ^

[2,4]
 ^
[6,8,10]
[10,8,6]
 ^

 2,10

 [2,10,4]
 4,8

*/
