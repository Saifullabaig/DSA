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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int n = q.size();
            Integer[] temp = new Integer[n];
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                if(flag){
                    temp[i] = node.val;
                }else{
                    temp[n-i-1] = node.val;
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            flag = !flag;
            res.add(Arrays.asList(temp));
        }
        return res;
    }
}
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/