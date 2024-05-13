//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    public static class Pair{
        int node;
        int distance;
        Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<ArrayList<ArrayList<Integer>>> adj
	                           =new ArrayList<ArrayList<ArrayList<Integer>>>();              
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<ArrayList<Integer>>());
	    }
	    
	     // making undirected graph in form of adjoint list: 
	     
	    for(int i=0;i<E;i++){
	        int u=edges[i][0];
	        ArrayList<Integer> temp=new ArrayList<>();
	        temp.add(edges[i][1]);
	        temp.add(edges[i][2]);
	        adj.get(u).add(temp);
	        
	        int v=edges[i][1];
	        ArrayList<Integer> temp2=new ArrayList<>();
	        temp2.add(edges[i][0]);
	        temp2.add(edges[i][2]);
	        adj.get(v).add(temp2);
	    }
	    
	    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
	    pq.add(new Pair(0, 0));
	    int[] vis = new int[V];
	    int sum = 0;
	    while(!pq.isEmpty()){
	        int node = pq.peek().node;
	        int wt= pq.peek().distance;
	        pq.remove();
	        if(vis[node] == 1) continue;
	        sum = sum+wt;
	        vis[node] = 1;
	        for(ArrayList<Integer> it: adj.get(node)){
	            int adjNode = it.get(0);
	            int adjWt = it.get(1);
	            if(vis[adjNode] == 0){
	                pq.add(new Pair(adjNode, adjWt));
	            }
	        }
	    }
	    return sum;
	}
}

//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1