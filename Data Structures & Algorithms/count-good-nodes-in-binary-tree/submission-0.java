/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int noOfGoodNodes = 0;
        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair(root, Integer.MIN_VALUE));
        while(!q.isEmpty()){
            int noOfNodes = q.size();
            for(int nodeNo=0;nodeNo<noOfNodes;nodeNo++){
                Pair<TreeNode, Integer> nodeMaxInPathPair = q.poll();
                TreeNode node = nodeMaxInPathPair.getKey();
                int maxInPath = nodeMaxInPathPair.getValue();
                if(maxInPath<=node.val){
                    noOfGoodNodes++;
                    maxInPath = node.val;
                }
                if(node.left!=null){
                    q.offer(new Pair(node.left, maxInPath));
                }
                if(node.right!=null){
                    q.offer(new Pair(node.right, maxInPath));
                }
            }
        }
        return noOfGoodNodes;
    }
}


/***

Observations -

Root will always be a good node


Idea -
I am thinking of keeping track of the maximum value of node seen till now, while visiting the current node
DFS like traversal

Store a pair?
Max seen till now for each node path?

(2,Integer.MIN_VALUE)
()

For each node, I'll check, if the max till now in its path is less than or equal to its value

(1,2), (1,2)

(1,2) (3,2)
(3,2) (1,2),(5,2)

(1,Integer.MIN_VALUE)

(2,1) (-1,1)
(-1,1) (3,2) , (4,2)


*/