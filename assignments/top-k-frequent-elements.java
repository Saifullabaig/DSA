class Solution {
    class Pair{
        int no;
        int freq;
        Pair(int no, int freq){
            this.no = no;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return b.freq - a.freq;
            }
        });
        for(Map.Entry<Integer, Integer> map: freq.entrySet()){
            pq.add(new Pair(map.getKey(), map.getValue()));
        }

        int[] ans = new int[k];
        int i =0;
        while(k-->0){
            ans[i++] = pq.poll().no;
        }
        return ans;
    }
}
//https://leetcode.com/problems/top-k-frequent-elements/