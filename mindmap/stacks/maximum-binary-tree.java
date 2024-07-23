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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> st = new LinkedList<>();
        for(int n: nums){
            TreeNode curr = new TreeNode(n);
            while(!st.isEmpty() && st.peek().val < n){
                curr.left = st.pop();
            }
            if(!st.isEmpty()){
                st.peek().right = curr;
            }
            st.push(curr);
        }
        return st.isEmpty() ? null : st.removeLast();
    }
}

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null || nums.length==0) return null;
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums, int l,int r){
        if(l>r) return null;
        if(l==r) return new TreeNode(nums[l]);
        int maxIdx = l;
        // find maxmium element
        for(int i=l;i<=r;i++){
            if(nums[i]>nums[maxIdx]) maxIdx = i;
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = helper(nums, l, maxIdx-1);
        root.right = helper(nums, maxIdx+1, r);
        return root;
    }
}

https://leetcode.com/problems/maximum-binary-tree/