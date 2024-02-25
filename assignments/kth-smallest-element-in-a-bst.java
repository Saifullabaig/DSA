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
        TreeNode small = find(root, new int[]{k});
        return small.val;
    }
    TreeNode find(TreeNode root, int[] k){
        if(root == null){
            return null;
        }
        TreeNode left = find(root.left, k);
        if(left != null){
            return left;
        }
        k[0]--;
        if(k[0] == 0){
            return root;
        }
        return find(root.right, k);
    }
}
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/