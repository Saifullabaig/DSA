class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rowFreq = new int[row];
        int[] colFreq = new int[col];
        for(int i=0;i<row;i++){
            for(int j=0; j<col;j++){
                if(matrix[i][j] == 0){
                    rowFreq[i] = 1;
                    colFreq[j] = 1;
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rowFreq[i] == 1 || colFreq[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
//https://leetcode.com/problems/set-matrix-zeroes/