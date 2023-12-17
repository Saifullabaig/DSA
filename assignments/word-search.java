class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]!= word.charAt(0)) continue;
                else{
                    boolean res = search(board, i, j, 0, word);
                    if (res) return true;
                }
            }
        }
        return false;
    }
    int[] di = new int[]{-1, 0, 1, 0};
    int[] dj = new int[]{0, -1, 0, 1};

    boolean search(char[][] board, int i, int j, int si, String s){
        if(si == s.length()) return true;
        if(i < 0 || i >= board.length || j<0 || j>= board[0].length) return false;
        if(board[i][j] != s.charAt(si)) return false;
        char myChar = board[i][j];
        board[i][j] = '@';
        for(int d=0;d<4;d++){
            boolean res = search(board, i+di[d], j+dj[d], si+1, s);
            if(res){
                board[i][j] = myChar;
                return true;
            }
        }
        board[i][j] = myChar;
        return false;
    }
}
//https://leetcode.com/problems/word-search/