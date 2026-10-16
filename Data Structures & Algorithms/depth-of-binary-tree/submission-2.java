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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxDepth = 0;
        // Stack will store the node and its depth
        Deque<Pair<TreeNode,Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair(root,1));
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> nodeDepthPair = stack.pop();
            TreeNode node = nodeDepthPair.getKey();
            int depth = nodeDepthPair.getValue();
            maxDepth = Math.max(maxDepth, depth);
            if(node.left != null){
                stack.push(new Pair(node.left,depth+1));
            }
            if(node.right != null){
                stack.push(new Pair(node.right,depth+1));
            }
        }
        return maxDepth;
    }
}
