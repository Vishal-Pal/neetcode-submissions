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
    public boolean isValidBST(TreeNode root) {
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while(node!=null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else{
                node = stack.pop();
                if(prev!=null && prev.val>=node.val){
                    return false;
                }
                prev = node;
                node = node.right;
            }
        }
        return true;
    }
}
