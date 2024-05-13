class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] ans = image;
        int inicolor = image[sr][sc];
        int[] di = new int[]{-1, 0 ,1, 0};
        int[] dj = new int[]{0, 1, 0, -1};
        dfs(image, sr, sc, color, inicolor, ans, di, dj);
        return ans;
    }
    void dfs(int[][] image, int sr, int sc, int color, int inicolor, int[][] ans, int[] di, int[] dj){
        ans[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;
        for(int i=0;i<4;i++){
            int nrow = sr + di[i];
            int ncol = sc + dj[i];
            if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && image[nrow][ncol] == inicolor 
            && ans[nrow][ncol] != color){
                dfs(image, nrow, ncol, color, inicolor, ans, di, dj);
            }
        }
    }

}
//https://leetcode.com/problems/flood-fill/