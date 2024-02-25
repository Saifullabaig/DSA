class Solution {
    public static List<List<Integer>> rotateImage(List<List<Integer>> matrix) { 
       int n = matrix.size();

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(j).get(i));
                matrix.get(j).set(i, temp);
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(i).get(n - 1 - j));
                matrix.get(i).set(n - 1 - j, temp);
            }
        }
      return matrix;
    }
}