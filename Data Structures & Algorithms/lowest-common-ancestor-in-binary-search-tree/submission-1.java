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
        List<TreeNode> pathToP = pathToNode(root, p);
        List<TreeNode> pathToQ = pathToNode(root, q);
        int ind = 0, len1 = pathToP.size(), len2 = pathToQ.size();
        while(ind<len1 && ind<len2 && pathToP.get(ind) == pathToQ.get(ind)){
            ind++;
        }
        return pathToP.get(ind-1);
    }

    public List<TreeNode> pathToNode(TreeNode root, TreeNode node){
        if(root == null || node == null){
            return Collections.emptyList();
        }
        List<TreeNode> path = new ArrayList<>();
        TreeNode ptr = root;
        while(ptr!=null){
            path.add(ptr);
            if(ptr.val == node.val){
                break;
            } else if(ptr.val > node.val){
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }
        return path;
    }
}

/**

Store the parents/ path to the nodes in some list
Compare those lists

3,4
5->3
5->3->4
last in the lists that is matching is 3, so I return 3


**/
