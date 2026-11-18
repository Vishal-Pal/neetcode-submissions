/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNewNodeMap = new HashMap<>();
        return cloneGraph(node, oldToNewNodeMap);
    }

    private Node cloneGraph(Node node, Map<Node, Node> oldToNewNodeMap){
        if(node == null){
            return null;
        }
        if(oldToNewNodeMap.containsKey(node)){
            return oldToNewNodeMap.get(node);
        }
        Node clone = oldToNewNodeMap.computeIfAbsent(node, k->new Node(node.val));
        for(Node neighbor:node.neighbors){
            clone.neighbors.add(cloneGraph(neighbor, oldToNewNodeMap));
        }
        return clone;
    }
}