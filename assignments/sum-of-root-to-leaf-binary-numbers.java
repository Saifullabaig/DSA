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
    public int sumRootToLeaf(TreeNode root) {
        return find(root, 0);
    }
    private int find(TreeNode root, int sum){
        if(root == null) return 0;
        sum = (2*sum) + root.val;
        if(root.left == null && root.right == null) return sum;
        return find(root.left, sum) + find(root.right, sum);
    }
}
//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/