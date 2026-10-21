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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ptr = root;
        int pVal = p.val, qVal = q.val;
        while(ptr != null){
            int val = ptr.val;
            if(val>pVal && val>qVal){
                ptr = ptr.left;
            } else if(val<pVal && val<qVal){
                ptr = ptr.right;
            } else{
                break;
            }
        }
        return ptr;
    }
}