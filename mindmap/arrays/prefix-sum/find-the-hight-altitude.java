class Solution {
    public int largestAltitude(int[] gain) {
        int alti = 0;
        int res = 0;
        for(int i=0;i<gain.length;i++){
            alti = alti + gain[i];
            if(alti>res){
                res = alti;
            }
        }
        return res;
    }
}
//https://leetcode.com/problems/find-the-highest-altitude/