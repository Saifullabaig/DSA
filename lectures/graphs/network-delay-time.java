class Solution {
    public class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        int[] dist = new int[n+1];
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.second - b.second);
        pq.add(new Pair(k, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int cur = p.first;
            int wt = p.second;
            for(Pair it: adj.get(cur)){
                int curDist = it.second + dist[cur];
                if(curDist < dist[it.first]){
                    dist[it.first] = curDist;
                    pq.add(new Pair(it.first, curDist));
                }
            }
        }
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }
        
        return maxDelay;
    }
}
//https://leetcode.com/problems/network-delay-time/