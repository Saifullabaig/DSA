class Solution {
    int res = 0;
    public int countArrangement(int n) {
        if(n == 0) return 0;
        backTrack(1, n, new int[n+1]);
        return res;
    }
    private void backTrack(int pos, int n, int[] usedVal){
        if(pos>n){
            res++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(usedVal[i] == 0 && (pos%i == 0 || i%pos == 0)){
                usedVal[i] = 1;
                backTrack(pos+1,n,usedVal);
                usedVal[i] = 0;
            }
        }
    }
}
//https://leetcode.com/problems/beautiful-arrangement/