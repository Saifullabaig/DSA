class Solution {
    public int minBitFlips(int start, int goal) {
        int res = 0;
        while(start != 0 || goal != 0){
            if((start & 1) != (goal & 1)) res++;
            start = start >> 1;
            goal = goal >> 1;
        }
        return res;
    }
}
//https://leetcode.com/problems/minimum-bit-flips-to-convert-number/