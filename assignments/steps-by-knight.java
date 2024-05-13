//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Possible moves for the Knight
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        // Create a chessboard to mark visited positions and store the steps
        int[][] chessboard = new int[N + 1][N + 1];
        for (int[] row : chessboard) {
            Arrays.fill(row, -1);
        }

        // Queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(KnightPos);
        chessboard[KnightPos[0]][KnightPos[1]] = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] currentPos = queue.poll();

            if (currentPos[0] == TargetPos[0] && currentPos[1] == TargetPos[1]) {
                return chessboard[currentPos[0]][currentPos[1]];
            }

            for (int i = 0; i < 8; i++) {
                int newX = currentPos[0] + dx[i];
                int newY = currentPos[1] + dy[i];

                if (newX >= 1 && newX <= N && newY >= 1 && newY <= N && chessboard[newX][newY] == -1) {
                    chessboard[newX][newY] = chessboard[currentPos[0]][currentPos[1]] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        // If the target position is not reachable
        return -1;
    }
}
//https://www.geeksforgeeks.org/problems/steps-by-knight5927/1