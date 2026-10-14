/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node ptr = head;
        // Create new nodes and interweave into the original list
        while(ptr!=null){
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        // Assign random pointers
        ptr = head;
        while(ptr!=null){
            if(ptr.random!=null){
                ptr.next.random = ptr.random.next;
            }
            ptr = ptr.next.next;
        }
        // Unweave the lists
        ptr = head;
        Node dummyHead = new Node(101);
        Node ptrNew = dummyHead;
        while(ptr!=null){
            ptrNew.next = ptr.next;
            ptr.next = ptr.next.next;
            ptr = ptr.next;
            ptrNew = ptrNew.next;
        }
        return dummyHead.next;
    }
}
