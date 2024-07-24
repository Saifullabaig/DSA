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
 class T {
    public boolean isBST;
    public Integer max;
    public Integer min;
    public Integer sum;
    public T(){
        this.isBST = false;
        this.max = null;
        this.min = null;
        this.sum = null;
    }
    
    public T(boolean isBST, int max, int min, int sum){
        this.isBST = isBST;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
 }
class Solution {
    private int ans = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return ans;
    }
    private T traverse(TreeNode root){
        if(root == null){
            return new T(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        T left = traverse(root.left);
        T right = traverse(root.right);

        if(!left.isBST || !right.isBST){
            return new T();
        }
        if(root.val<=left.max || root.val >= right.min){
            return new T();
        }
        int sum = root.val + left.sum + right.sum;
        ans = Math.max(ans, sum);
        return new T(true, Math.max(root.val, right.max), Math.min(root.val, left.min), sum);
    }
}
//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/