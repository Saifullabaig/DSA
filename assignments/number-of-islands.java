class Solution {
    public class Pair{
        int first;
        int second;
        Pair(int x, int y){
            this.first = x;
            this.second = y;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    bfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(int row, int col, char[][] grid, int[][] vis){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int m = grid.length;
        int n = grid[0].length;
        int[] di = new int[] {-1, 0, 1, 0};
        int[] dj = new int[] {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair top = q.poll();
            int r = top.first;
            int c = top.second;
            for(int i=0;i<4;i++){
                int nrow = r + di[i];
                int ncol = c + dj[i];
                if(nrow>=0 && nrow<m && ncol >= 0 && ncol<n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }
}
//https://leetcode.com/problems/number-of-islands/