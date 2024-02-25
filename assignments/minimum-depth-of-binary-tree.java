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
    public int minDepth(TreeNode root) {
        return minimum(root);
    }
    int minimum(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = minimum(root.left);
        int r = minimum(root.right);
        // In that case we the length of left subtree will be 0 and assuming right substree is non zero. min(left,right) will give 0+1 =1 which is WA. To avoid that case we are doing ( left == 0 || right == 0)? right + left+1.
        if(l == 0 || r == 0){
            return l+r+1;
        }else{
        return Math.min(l,r)+1;
        }
    }
}
//https://leetcode.com/problems/minimum-depth-of-binary-tree/