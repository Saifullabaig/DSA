class Solution {
    public int maximumScore(int a, int b, int c) {
        int score = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> (y-x));
        pq.add(a);
        pq.add(b);
        pq.add(c);
        while(pq.size()>1){
            int highest = pq.poll()-1;
            int second_highest = pq.poll()-1;
            if(highest > 0){
                pq.add(highest);
            }
            if(second_highest > 0){
                pq.add(second_highest);
            }
            score++;
        }
        return score;
    }
}
//https://leetcode.com/problems/maximum-score-from-removing-stones/