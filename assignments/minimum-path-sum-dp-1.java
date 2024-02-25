class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return find(n-1, m-1, grid, dp);
    }
    int find(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(i<0 || j<0 ){
            return (int) Math.pow(10, 9);
        }
        if(dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + find(i-1, j, grid, dp);
        int left = grid[i][j] + find(i, j-1, grid, dp);
        return dp[i][j] = Math.min(up, left);
    }
}
//https://leetcode.com/problems/minimum-path-sum/