class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] count = new int[n+1];
        for(List<Integer> i: edges){
            count[i.get(1)]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(count[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}
//https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/