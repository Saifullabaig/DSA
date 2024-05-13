class Solution {
    public class DisjointSet{
        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<=n;i++){
                rank.add(0);
                parent.add(i);
            }
        }

        public int findUltimateParent(int node){
            if(node == parent.get(node)){
                return node;
            }
            int ulP = findUltimateParent(parent.get(node));
            parent.set(node, ulP);
            return parent.get(node);
        }
        public void unionByRank(int u, int v){
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);
            if(ulp_u == ulp_v) return;
            if(rank.get(ulp_u) < rank.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
            }
            else if(rank.get(ulp_v) < rank.get(ulp_u)){
                parent.set(ulp_u, ulp_v);
            }else{
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;
        int m = connections.length;
        for(int i=0;i<m;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findUltimateParent(u) == ds.findUltimateParent(v)){
                cntExtras++;
            }else{
                ds.unionByRank(u,v);
            }
        }

        int cntC = 0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i) == i) cntC++;
        }
        int ans = cntC-1;
        if(cntExtras >= ans) return ans;
        return -1;
    }
}
//https://leetcode.com/problems/number-of-operations-to-make-network-connected/