class Solution {
    public class Pair{
        int node;
        long d;
        Pair(int node, long d){
            this.node = node;
            this.d = d;
        }
    }
    public int MOD = (int) (1e9 + 7);
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1], (long) roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], (long) roads[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.d, b.d));
        pq.add(new Pair(0,0));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE/2);
        dist[0] = 0;
        int[] ways = new int[n];
        ways[0] = 1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            long d = p.d;
            for(Pair np: adj.get(node)){
                int newNode = np.node;
                long newD = np.d;
                if(d+newD < dist[newNode]){
                    ways[newNode] = ways[node];
                    dist[newNode] = d + newD;
                    pq.add(new Pair(newNode, d+newD));
                }else if(d+newD == dist[newNode]){
                    ways[newNode] = (ways[newNode] + ways[node])%MOD;
                }
            }
        }
        return ways[n-1]%MOD;
    }
}
//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/