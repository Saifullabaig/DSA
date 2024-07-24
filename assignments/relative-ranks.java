class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1,p2) -> (p2.getValue() - p1.getValue()));
        for(int i=0;i<n;i++){
            pq.add(new Pair(i, score[i]));
        }
        String[] ans = new String[n];
        int place = 1;
        while(!pq.isEmpty()){
            Pair<Integer,Integer> top = pq.poll();
            int curr = top.getKey();
            if(place == 1){
                ans[curr] = "Gold Medal";
            } else if(place == 2){
                ans[curr] = "Silver Medal";
            }else if(place == 3){
                ans[curr] = "Bronze Medal";
            }else{
                ans[curr] = String.valueOf(place);
            }
            place++;
        }
        return ans;
    }
}
//https://leetcode.com/problems/relative-ranks/