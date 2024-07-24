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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        traverse(root, res);
        return res;
    }
    private void traverse(Node root, List<Integer> res){
        if(root.children == null){
            res.add(root.val);
            return;
        }
        for(Node n: root.children){
            traverse(n, res);
        }
        res.add(root.val);
    }
}
//https://leetcode.com/problems/n-ary-tree-postorder-traversal/