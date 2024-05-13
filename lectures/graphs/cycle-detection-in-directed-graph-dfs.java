//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis = new int[V];
        int[] rec = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                if(help(i, adj, vis, rec)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean help(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] rec){
        if(vis[i]==0){
            vis[i] = 1;
            rec[i] =1;
            for(int j: adj.get(i)){
                if(help(j, adj, vis, rec)){
                    return true;
                }
            }
            rec[i] = 0;
        }
        else if(vis[i]==1 && rec[i] == 1){
            return true;
        }
        return false;
    }
}
//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1