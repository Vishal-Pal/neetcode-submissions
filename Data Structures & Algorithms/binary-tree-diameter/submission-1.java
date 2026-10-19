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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int diameter = 0;
        Map<TreeNode, Integer> nodeHeightMap = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while(node!=null || !stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node = node.left;
            } else{
                node = stack.peek();
                // If no right child or the right child is already processed, process this node
                if(node.right == null || nodeHeightMap.containsKey(node.right)){
                    int leftHeight = nodeHeightMap.getOrDefault(node.left, 0);
                    int rightHeight = nodeHeightMap.getOrDefault(node.right, 0);
                    diameter = Math.max(diameter, leftHeight+rightHeight);
                    nodeHeightMap.put(node, 1+Math.max(leftHeight, rightHeight));
                    stack.pop();
                    node = null;                    
                } else{
                    // Move to right child
                    node = node.right;
                }
            }
        }
        return diameter;
    }
}
