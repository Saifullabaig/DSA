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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }
    private void helper(TreeNode root, String s, List<String> res){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            s=s+root.val;
            res.add(s);
            return;
        }
        s = s+root.val;
        s = s + "->";
        helper(root.left, s, res);
        helper(root.right, s, res);
    }
}
//https://leetcode.com/problems/binary-tree-paths/