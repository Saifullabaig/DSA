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
    ArrayList<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
       inorder(root);
        int len = list.size();
        int l = 0, r = len - 1;
        
        while(l < r){
            if(list.get(l) + list.get(r) == k)
                return true;
            else if (list.get(l) + list.get(r) > k)
                r--;
            else
                l++;
        }
        return false;
    }
    
    public void inorder(TreeNode node){
        if(node == null) return;
        
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
}
//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/