import java.util.*;

public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        // Write your code here.
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m= edges.length;
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i] = (int)1e9;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it: adj.get(node)){
                if(dist[node]+1<dist[it]){
                    dist[it] = dist[node]+1;
                    q.add(it);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }
}
//https://www.codingninjas.com/studio/problems/single-source-shortest-path_8416371?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION