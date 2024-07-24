class Solution {
    public int findTheWinner(int n, int k) {
        k = k > n ? k % n : k;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        while(q.size()>1){
            for(int num =1;num<k;num++){
                q.add(q.poll());
            }
            q.poll();
        }
        return q.poll();
    }
}
//https://leetcode.com/problems/find-the-winner-of-the-circular-game/