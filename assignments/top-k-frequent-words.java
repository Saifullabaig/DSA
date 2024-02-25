class Solution {
    class Pair{
        String word;
        int no;
        Pair(String word, int no){
            this.word = word;
            this.no = no;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String word: words){
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.no == b.no) return a.word.compareTo(b.word);
            else return b.no - a.no;
        });

        for(String word: freq.keySet()){
            pq.add(new Pair(word, freq.get(word)));
        }
        List<String> res= new ArrayList<>();
        while(k-->0){
            res.add(pq.poll().word);
        }
        return res;
    }

}
//https://leetcode.com/problems/top-k-frequent-words/