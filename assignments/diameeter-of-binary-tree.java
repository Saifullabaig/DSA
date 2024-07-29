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
    int maxi = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return maxi;
    }

    private int find(TreeNode root){
        if(root== null){
            return 0;
        }
        int lh = find(root.left);
        int rh = find(root.right);
        maxi = Math.max(maxi, lh+rh);
        return 1 + Math.max(lh, rh);
    }
}
//https://leetcode.com/problems/diameter-of-binary-tree/