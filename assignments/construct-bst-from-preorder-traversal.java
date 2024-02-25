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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int e: preorder){
            root = construct(root, e);
        }
        return root;
    }
    private TreeNode construct(TreeNode root, int e){
        if(root == null){
            return root = new TreeNode(e);
        }
        if(root.val > e){
            root.left = construct(root.left, e);
        }
        else{
            root.right = construct(root.right, e);
        }
        return root;
    }
}
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/