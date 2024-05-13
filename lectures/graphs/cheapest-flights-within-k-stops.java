class Solution {
    public class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public class Tuple{
        int first;
        int second;
        int third;
        Tuple(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        int dist[] = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        q.add(new Tuple(0,src,0));
        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;
            if(stops>k) continue;
            for(Pair iter: adj.get(node)){
                int adjNode= iter.first;
                int edW = iter.second;
                if(cost + edW < dist[adjNode] && stops<=k){
                    dist[adjNode] = cost+edW;
                    q.add(new Tuple(stops+1, adjNode, cost+edW));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}
//https://leetcode.com/problems/cheapest-flights-within-k-stops/