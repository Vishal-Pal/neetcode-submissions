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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        Map<TreeNode, Integer> nodeHeightMap = new HashMap<>();
        nodeHeightMap.put(null, 0);
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(node!=null || !stack.isEmpty()){
            // Move as much left as possible
            if(node!=null){
                stack.push(node);
                node = node.left;
            } else{
                node = stack.peek();
                // If node has no right child or its right child is already processed
                if(node.right == null || nodeHeightMap.containsKey(node.right)){
                    int leftHeight = nodeHeightMap.get(node.left);
                    int rightHeight = nodeHeightMap.get(node.right);
                    if(Math.abs(leftHeight-rightHeight)>1){
                        return false;
                    }
                    nodeHeightMap.put(node, 1+Math.max(leftHeight, rightHeight));
                    stack.pop();
                    node = null;
                } else{
                    // Process right child first
                    node = node.right;
                }
            }
        }
        return true;
    }
}
