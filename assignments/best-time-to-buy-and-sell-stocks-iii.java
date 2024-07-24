class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int n = prices.length;
        int[] dp = new int[n];

        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1], prices[i] - min);
            if(min > prices[i]) min = prices[i];
        }
        int res = dp[n-1];
        int max = prices[n-1];
        int prev = 0;
        for(int i=n-2;i>=0;i--){
            prev = Math.max(prev, max-prices[i]);
            res = Math.max(res, prev+dp[i]);
            if(max<prices[i]) max = prices[i];
        }
        return res;
    }
}
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/