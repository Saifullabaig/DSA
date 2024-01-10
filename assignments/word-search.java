class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] != word.charAt(0)) continue;
                else{
                    boolean res = find(board, word, i, j, 0);
                    if (res){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int i, int j, int index){
        if(index == word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        if(board[i][j]!=word.charAt(index)) return false;
        
        char myChar = board[i][j];
        board[i][j] = '@';
        boolean res = false;
        if(find(board, word, i+1, j, index+1) || find(board, word, i, j+1, index+1) || 
        find(board, word, i-1, j, index+1) || find(board, word, i, j-1, index+1)) {
            board[i][j] = myChar;
            return true;
        }
        board[i][j] = myChar;
        return false;
    }
}
//https://leetcode.com/problems/word-search/