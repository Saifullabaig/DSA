/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int n = q.size();
            for(int i=0;i<n;i++){
                Node curr = q.poll();
                level.add(curr.val);
                for(int j=0;j<curr.children.size();j++){
                    q.add(curr.children.get(j));
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
//https://leetcode.com/problems/n-ary-tree-level-order-traversal/