class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0]= 1;
        find(nums, target, dp);
        return dp[target];
    }

    int find(int[] nums, int target, int[] dp){
        if(dp[target]>-1){
            return dp[target];
        }
        int res = 0;
        for(int i: nums){
            if(i<=target){
                res+=find(nums, target-i, dp);
            }
        }
        dp[target] = res;
        return dp[target];
    }
}
//https://leetcode.com/problems/combination-sum-iv/