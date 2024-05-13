class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            if(i==headID) continue;
            adj[manager[i]].add(i);
        }
        Queue<int[]> q = new LinkedList<>();
        int maxT = 0;
        int vis = 0;
        q.add(new int[]{headID, 0});
        while(!q.isEmpty()){
            int[] front = q.poll();
            maxT = Math.max(maxT, front[1]);
            vis++;
            if(vis == n){
                return maxT;
            }
            for(int i: adj[front[0]]){
                q.offer(new int[]{i, front[1]+informTime[front[0]]});
            }
        }
        return maxT;
    }
}
//https://leetcode.com/problems/time-needed-to-inform-all-employees/