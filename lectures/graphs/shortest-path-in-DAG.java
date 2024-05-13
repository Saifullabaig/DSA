import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    public static class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int[] shortestPathInDAG(int n, int m, int [][]edges) {
        // Write your code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            adj.get(u).add(new Pair(v, wt));
        }
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                topoSort(i, adj, vis, st);
            }
        }

        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i] = (int) 1e9;
        dist[0] = 0;
        while(!st.isEmpty()){
            int node= st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                if(dist[node]+wt<dist[v]){
                    dist[v] = dist[node] + wt;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }

        }
        return dist;

    }
    private static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st){
        vis[node] = 1;
        for(int i=0;i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }
}
//https://www.codingninjas.com/studio/problems/shortest-path-in-dag_8381897?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION