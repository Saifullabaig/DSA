class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] suff = new int[n];
        int[] pref = new int[n];
        suff[0] = nums[0];
        pref[n-1] = nums[n-1];
        int k = 0;
        for(int i=1;i<n;i++){
            k = n-i-1;
            suff[i] = nums[i] + suff[i-1];
            pref[k] = nums[k] + pref[k+1];
        }

        for(int j=0;j<nums.length;j++){
            if(suff[j] == pref[j]){
                return j;
            }
        }
        return -1;
    }
}
//https://leetcode.com/problems/find-pivot-index/