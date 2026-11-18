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
        if(node == null){
            return null;
        }
        Map<Node, Node> oldToNewNodeMap = new HashMap<>();
        cloneGraph(node, oldToNewNodeMap, new HashSet<>());
        return oldToNewNodeMap.get(node);
    }

    private void cloneGraph(Node node, Map<Node, Node> oldToNewNodeMap, Set<Node> visited){
        if(node == null || visited.contains(node)){
            return;
        }
        Node clone = oldToNewNodeMap.computeIfAbsent(node, k->new Node(node.val));
        visited.add(node);
        List<Node> neighbors = node.neighbors;
        if(neighbors == null || neighbors.isEmpty()){
            return;
        }
        List<Node> cloneNeighbors = new ArrayList<>();
        for(Node neighbor:neighbors){
            cloneGraph(neighbor, oldToNewNodeMap, visited);
            cloneNeighbors.add(oldToNewNodeMap.get(neighbor));
        }
        clone.neighbors = cloneNeighbors;
    }
}