class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[][] res = new int[rowLen][colLen];
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                int rowStart = i-k;
                int rowEnd = i+k;
                int colStart = j-k;
                int colEnd = j+k;

                if(rowStart<0){
                    rowStart = 0;
                }
                if(rowEnd >= rowLen){
                    rowEnd = rowLen-1;
                }
                if(colStart < 0){
                    colStart = 0;
                }
                if(colEnd >= colLen){
                    colEnd = colLen-1;
                }
                res[i][j] = blockSum(mat, rowStart, rowEnd, colStart, colEnd);
            }
        }
        return res;
    }
    int blockSum(int[][] mat, int rowStart, int rowEnd, int colStart, int colEnd){
        int sum =0;
        for(int i=rowStart;i<=rowEnd;i++){
            for(int j=colStart;j<=colEnd;j++){
                sum+=mat[i][j];
            }
        }
        return sum;
    }
}
//https://leetcode.com/problems/matrix-block-sum/