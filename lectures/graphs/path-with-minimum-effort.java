class Solution {
    public class Tuple{
        int row;
        int col;
        int distance;
        Tuple(int row,int  col,int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int n = heights.length;
        int m = heights[0].length;
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Tuple(0, 0, 0));
        dist[0][0] = heights[0][0];
        int[] dx = new int[]{-1,0,0,1};
        int[] dy = new int[]{0,1,-1,0};
        while(!pq.isEmpty()){
            Tuple it = pq.poll();
            int row = it.row;
            int col = it.col;
            int diff = it.distance;
            if (diff > dist[row][col]) continue;
            if(row == n-1 && col == m-1) return diff;

            for(int i=0;i<4;i++){
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                if(nrow>=0 && nrow<n && ncol >= 0 && ncol<m){
                    int newDiff = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);
                    if(newDiff < dist[nrow][ncol]){
                        dist[nrow][ncol] = newDiff;
                        pq.add(new Tuple(nrow, ncol, newDiff));
                    }
                }
            }
        }
        return 0;
    }
}
//https://leetcode.com/problems/path-with-minimum-effort/