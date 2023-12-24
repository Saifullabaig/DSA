import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList < String > findSum(int[][] arr, int n) {
        // Write your code here.
        ArrayList<String> res = new ArrayList<>();
        if(arr[0][0] == 0) return res;
        boolean[][] visited = new boolean[n][n];
        solve(arr, n, 0, 0, visited, new StringBuilder(""), res);
        return res;
    }

    private static void solve(int[][] arr, int n, int row, int col, boolean[][] visited, StringBuilder s, ArrayList<String> res){
        if(row == n-1 && col == n-1){
            res.add(s.toString());
            return;
        }
        char[] dir = new char[]{'D','L','R','U'};
        int[] rowArr = new int[]{1, 0, 0, -1};
        int[] colArr = new int[]{0, -1, 1, 0};
        visited[row][col] = true;
        for(int i=0;i<4;i++){
            int nRow = row + rowArr[i];
            int nCol = col + colArr[i];
            if(isSafe(arr, n, nRow, nCol, visited)){
                s.append(dir[i]);
                solve(arr, n, nRow, nCol, visited, s, res);
                s.deleteCharAt(s.length()-1);
            }

        }
        visited[row][col] = false;
    }

    private static boolean isSafe(int[][] arr, int n, int r, int c, boolean[][] visited){
        if(r >=0 && r<n && c>=0 && c<n && !visited[r][c] && arr[r][c] == 1){
            return true;
        }
        return false;
    }
}