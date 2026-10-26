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
    public int kthSmallest(TreeNode root, int k) {
        // Do inorder traversal
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        int ind = 0;
        while(node!=null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else{
                node = stack.pop();
                ind++;
                if(ind == k){
                    return node.val;
                }
                node = node.right;
            }
        }
        return -1;
    }
}

/***

Do the inorder traversal of the BST
And keep track of the smallest element
and keep an index and keep incrementing it
when that index matches k then return the node's value

ind = 0
I get the node that is now to be added in the inorder list
First increase ind by 1, if ind is equal to k, then I'll return the value


*/
