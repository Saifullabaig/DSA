class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i= 0; i<V;i++){
            for(int j=0; j<V;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int[] vis = new int[V+1];
        int cnt = 0;
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i, adj, vis);
            }
        }
        return cnt;
    }

    void dfs(int i, List<List<Integer>> adj, int[] vis){
        vis[i] = 1;
        for(Integer it: adj.get(i)){
            if(vis[it] == 0)
            {
                dfs(it, adj, vis);
            }
        }
    }
}
//https://leetcode.com/problems/number-of-provinces/