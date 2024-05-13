class Solution {
    class Node {
    int first;
    int second;
    int third; 
    Node(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];
        int[][] dist = new int[m][n];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new Node(i, j, 0));
                }else{
                vis[i][j] = 1;
                }
            }
        }

        int[] di = new int[]{-1,0,1,0};
        int[] dj = new int[]{0,1,0,-1};
        while(!q.isEmpty()){
            Node node = q.poll();
            int row = node.first;
            int col = node.second;
            int steps = node.third;
            dist[row][col] = steps;
            for(int i=0;i<4;i++){
                int nrow = row+di[i];
                int ncol = col+dj[i];
                if(nrow >=0 && ncol >=0 && nrow < m && ncol < n && vis[nrow][ncol] == 1){
                    vis[nrow][ncol] = 0;
                    q.add(new Node(nrow, ncol, steps+1));
                }
            }
        }
        return dist;
    }
}

//https://leetcode.com/problems/01-matrix/