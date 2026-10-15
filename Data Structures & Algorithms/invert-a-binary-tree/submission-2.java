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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int noOfNodesAtLevel = q.size();
            // Only process nodes at the same level
            for(int nodeNo=0;nodeNo<noOfNodesAtLevel;nodeNo++){
                // Take out front node
                TreeNode node = q.poll();
                // Invert its left and right subtrees
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return root;
    }
}
