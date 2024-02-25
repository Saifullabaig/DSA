class Solution {
    class Pair{
        char ch;
        int freq;
        public Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq == b.freq ? a.ch - b.ch : b.freq - a.freq);

        for(Character c: map.keySet()){
            pq.add(new Pair(c, map.get(c)));
        }

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            char character = pair.ch;
            int frequency = pair.freq;
            while(frequency>0){
                res.append(character);
                frequency--;
            }
        }
        return res.toString();
    }
}
//https://leetcode.com/problems/sort-characters-by-frequency/