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
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderFn(root, inOrder);
        for(int i=0;i<inOrder.size()-1;i++){
            if(inOrder.get(i) >= inOrder.get(i+1)){
                return false;
            }
        }
        return true;
    }
    void inOrderFn(TreeNode root, List<Integer> inOrder){
        if(root!=null){
            inOrderFn(root.left, inOrder);
            inOrder.add(root.val);
            inOrderFn(root.right, inOrder);
        }
    }
}
//https://leetcode.com/problems/validate-binary-search-tree/