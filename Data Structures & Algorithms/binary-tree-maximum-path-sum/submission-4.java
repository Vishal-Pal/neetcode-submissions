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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    // Returns max path sum to parent including the current node
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int rootVal = root.val;
        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));
        int sumToParentIncludingRoot = rootVal+Math.max(leftSum, rightSum);
        maxSum = Math.max(maxSum, rootVal+leftSum+rightSum);
        return sumToParentIncludingRoot;
    }
}

/***

Observations
Path - Nodes shall be reachable from each other

It's not necessary to start from parent-child
child-parent-otherChild is also a valid path

Can I break this down recursively?
Does having the maxPathSum from the left and right subtree help?


leftSum = 10
root.val = -15
rightSum = 40

if all are negative choose the maximum one
if root.val is negative - it shan't be considered in 

Diameter like approach here?

Keeping a global variable of sorts?

root sum - Include the root
Only including the root isn't the case here
we may include exclude root
or discard the left or right

3 possible values for current max path sum -
Either root+left+right
root>0 => Include root

Root is positive
1
Take root only => root >0 and leftSum< 0 and rightSum<0
2
Take root and left child root > 0 and leftSum > 0
3
Take root and right child root > 0 and rightSum > 0 
4
Take root, left child and right child root > 0 leftSum > 0 rightSum > 0
5
Take left child root < 0 leftSum > 0 rightSum <0
6
Take left child and right child root < 0 leftSum > 0 rightSum <0
7
Take right child root < 0 leftSum < 0 rightSum > 0
if(root >= 0){

if(leftSum >= 0){
if(rightSum>=0){
} else{
}
}else if(rightSum>=0){
} else{
}
}

If root is negative
We can either take left or right or root


*/
