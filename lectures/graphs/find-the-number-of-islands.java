//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int m = grid.length;
        int n= grid[0].length;
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
        while(!q.isEmpty()){
            Pair top = q.poll();
            int r = top.first;
            int c = top.second;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int nrow = r+i;
                    int ncol = c+j;
                    if(nrow>=0 && nrow<m && ncol >= 0 && ncol<n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                        q.add(new Pair(nrow, ncol));
                        vis[nrow][ncol] = 1;
                    }
                }
            }
        }
    }
}

//https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article