class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revAdj = new ArrayList<>();
        int V = graph.length;
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            revAdj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int it: graph[i]){
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0) q.add(i);
        }
        List<Integer> safeNodes = new ArrayList<>();
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            safeNodes.add(node);
            for(int it: revAdj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
//https://leetcode.com/problems/find-eventual-safe-states/