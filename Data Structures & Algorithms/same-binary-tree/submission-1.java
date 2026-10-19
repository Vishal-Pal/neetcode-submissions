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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<Pair<TreeNode, TreeNode>> stack = new ArrayDeque<>();
        stack.push(new Pair(p,q));
        while(!stack.isEmpty()){
            Pair<TreeNode, TreeNode> nodePair = stack.pop();
            TreeNode node1 = nodePair.getKey();
            TreeNode node2 = nodePair.getValue();
            if(node1==null && node2==null){
                continue;
            } else if(node1==null || node2==null || node1.val != node2.val){
                return false;
            }
            stack.push(new Pair(node1.left, node2.left));
            stack.push(new Pair(node1.right, node2.right));
        }
        return true;
    }
}
