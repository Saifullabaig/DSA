/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> vis = new HashMap<>();
        Node copy = new Node(node.val);
        vis.put(node.val, copy);
        for(Node adj: node.neighbors){
            if(!vis.containsKey(adj.val)){
                Node newNode = new Node(adj.val);
                copy.neighbors.add(newNode);
                dfs(adj, newNode, vis);
            }else{
                copy.neighbors.add(vis.get(adj.val));
            }
        }
        return copy;
    }

    private void dfs(Node curr, Node node, Map<Integer, Node> vis){
        vis.put(node.val, node);
        for(Node adj: curr.neighbors){
            if(!vis.containsKey(adj.val)){
                Node newNode = new Node(adj.val);
                node.neighbors.add(newNode);
                dfs(adj, newNode, vis);
            }else{
                node.neighbors.add(vis.get(adj.val));
            }
        }
    }
}
//https://leetcode.com/problems/clone-graph/