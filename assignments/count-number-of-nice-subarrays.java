class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n+1];
        int t = 0;
        int ans = 0;
        cnt[0] = 1;
        for(int num: nums){
            t += num & 1; // to check odd or even

            if(t-k >=0){
                ans += cnt[t-k];
            }
            cnt[t]++;
        } 
        return ans;
    }
}
//https://leetcode.com/problems/count-number-of-nice-subarrays/