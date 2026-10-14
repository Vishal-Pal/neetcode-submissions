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
        Map<Node, Node> nodeToRandomNodeMap = new HashMap<>();
        Node ptr = head;
        Node dummyHead = new Node(101);
        Node ptr2 = dummyHead;
        while(ptr!=null){
            Node newNode = new Node(ptr.val);
            ptr2.next = newNode;
            ptr2 = ptr2.next;
            nodeToNewNodeMap.put(ptr, newNode);
            nodeToRandomNodeMap.put(ptr, ptr.random);
            ptr = ptr.next;
        }
        for(Node node:nodeToNewNodeMap.keySet()){
            Node newNode = nodeToNewNodeMap.get(node);
            Node oldRandom = nodeToRandomNodeMap.get(node);
            Node newRandom = nodeToNewNodeMap.get(oldRandom);
            newNode.random = newRandom;
        }
        return dummyHead.next;
    }
}
