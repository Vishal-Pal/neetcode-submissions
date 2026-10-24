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
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair(root, Integer.MIN_VALUE));
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> nodeMaxInPathPair = stack.pop();
            TreeNode node = nodeMaxInPathPair.getKey();
            int maxInPath = nodeMaxInPathPair.getValue();
            if(maxInPath<=node.val){
                noOfGoodNodes++;
                maxInPath = node.val;
            }
            if(node.left!=null){
                stack.push(new Pair(node.left, maxInPath));
            }
            if(node.right!=null){
                stack.push(new Pair(node.right, maxInPath));
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