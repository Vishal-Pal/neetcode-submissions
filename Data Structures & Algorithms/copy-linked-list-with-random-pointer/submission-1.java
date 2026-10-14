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
        Map<Node, Node> nodeToNewNodeMap = new HashMap<>();
        Node ptrOld = head;
        Node dummyHead = new Node(101);
        Node ptrNew = dummyHead;
        while(ptrOld!=null){
            Node newNode = nodeToNewNodeMap.computeIfAbsent(ptrOld, k->new Node(k.val));
            Node oldRandom = ptrOld.random;
            if(oldRandom!=null){
                Node newRandom = nodeToNewNodeMap.computeIfAbsent(oldRandom, k->new Node(k.val));
                newNode.random = newRandom;
            }
            ptrNew.next = newNode;
            ptrNew = ptrNew.next;
            ptrOld = ptrOld.next;
        }
        return dummyHead.next;
    }
}
