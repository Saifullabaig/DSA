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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxDownPath(root);
        return maxi;
    }

    private int maxDownPath(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = Math.max(0, maxDownPath(root.left));
        int rh = Math.max(0, maxDownPath(root.right));
        maxi = Math.max(maxi, lh+rh+root.val);
        return Math.max(lh, rh) + root.val;
    }
}
//https://leetcode.com/problems/binary-tree-maximum-path-sum/