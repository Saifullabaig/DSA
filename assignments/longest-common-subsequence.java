class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int dp[][] = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                dp[i][j] = -1;
            }
        }
        return lcs(text1, text2, n1, n2, dp);
    }

    int lcs(String text1, String text2, int n1, int n2, int[][] dp){
        if(n1 == 0 || n2 == 0){
            return 0;
        }
        if(dp[n1][n2] != -1){
            return dp[n1][n2];
        }

        if(text1.charAt(n1-1) == text2.charAt(n2-1)){
            dp[n1][n2] = 1 + lcs(text1, text2, n1-1, n2-1, dp);
            return dp[n1][n2];
        }
        dp[n1][n2] = Math.max(lcs(text1, text2, n1-1, n2, dp), lcs(text1, text2, n1, n2-1, dp));
        return dp[n1][n2];
    }

}
//https://leetcode.com/problems/longest-common-subsequence/