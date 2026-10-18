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
        if(!isBalanced(root.left) || !isBalanced(root.right)){
            return false;
        }
        int maxHeightLeft = maxHeight(root.left);
        int maxHeightRight = maxHeight(root.right);
        return Math.abs(maxHeightLeft-maxHeightRight)<=1;
    }

    private int maxHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(maxHeight(root.left), maxHeight(root.right));
    }
}
