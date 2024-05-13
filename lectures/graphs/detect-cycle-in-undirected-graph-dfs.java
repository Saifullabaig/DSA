import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Solution {
    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            // Write your code here.
            int[] vis = new int[V+1];
            for(int i=0;i<V;i++){
                if(vis[i] == 0){
                    if(dfs(i,-1, adj,V,vis)){
                        return true;
                    }
                }
            }
            return false;
        }

        boolean dfs(int node, int parent, List<List<Integer>> adj, int V, int[] vis){
            vis[node] = 1;
            for(int adjNode: adj.get(node)){
                if(vis[adjNode] == 0){
                    if(dfs(adjNode, node, adj, V, vis)) return true;
                }else if(parent != adjNode){
                    return true;
                }
            }
            return false;
        }
    };
}
//https://www.codingninjas.com/studio/problems/detect-cycle-in-an-undirected-graph-_758967?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION