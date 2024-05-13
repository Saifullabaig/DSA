class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 0 && m == 1 && n == 1) return 1;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        vis[0][0] = 1;
        q.add(new int[]{0,0,1});

        int[] dx = new int[] {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = new int[] {0, 0, -1, 1, -1, 1, -1, 1};
        while(!q.isEmpty()){
            int[] coor = q.poll();
            for(int i=0;i<8;i++){
                int x = coor[0] + dx[i];
                int y = coor[1] + dy[i];
                int steps = coor[2];
                if(x >=0 && y>=0 && x<n && y<m && vis[x][y] == 0 && grid[x][y] == 0){
                    if(x == n-1 && y == m-1) return steps+1;
                    q.add(new int[]{x,y,steps+1});
                    vis[x][y]=1;
                }
            }
        }
        return -1;
    }
}
//https://leetcode.com/problems/shortest-path-in-binary-matrix/