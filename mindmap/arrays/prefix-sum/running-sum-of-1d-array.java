class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int[] res = new int[n];
        for(int i =0;i<n;i++){
            sum = sum + nums[i];
            res[i] = sum;
        }
        return res;
    }
}
//https://leetcode.com/problems/running-sum-of-1d-array/