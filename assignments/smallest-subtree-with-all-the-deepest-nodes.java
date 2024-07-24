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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh == rh) return root;
        if(lh>rh) return subtreeWithAllDeepest(root.left);
        else return subtreeWithAllDeepest(root.right);
    }
    int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right))+1;
    }
}
//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/