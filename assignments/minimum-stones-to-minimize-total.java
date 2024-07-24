class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> (y-x));
        for(int p: piles){
            pq.add(p);
        }
        for(int i=0;i<k;i++){
            int top= pq.poll();
            pq.add(top - (top/2));
        }
        int ans = 0;
        while(!pq.isEmpty()){
            ans+=pq.poll();
        }
        return ans;
    }
}
//leetcode.com/problems/remove-stones-to-minimize-the-total/