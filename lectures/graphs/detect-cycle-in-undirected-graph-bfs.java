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
                    if(detect(i, adj,V,vis)){
                        return true;
                    }
                }
            }
            return false;
        }

        boolean detect(int i, List<List<Integer>> adj, int V, int[] vis){
            vis[i] = 1;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{i, -1});
            while(!q.isEmpty()){
                int[] top = q.poll();
                int node = top[0];
                int parent = top[1];
                for(int it: adj.get(node)){
                    if(vis[it] == 0){
                        vis[it] =1;
                        q.add(new int[]{it, node});
                    }else if(parent != it){
                        return true;
                        
                    }
                }
            }
            return false;
        }
    };
}
//https://www.codingninjas.com/studio/problems/detect-cycle-in-an-undirected-graph-_758967?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION