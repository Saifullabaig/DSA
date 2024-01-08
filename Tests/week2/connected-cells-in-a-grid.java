import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(List<List<Integer>> matrix) {
    // Write your code here
        int max = 0;
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(0).size();j++){
                if(matrix.get(i).get(j) == 1){
                    int currMax = dfs(i, j, matrix);
                    max = Math.max(max, currMax);
                }
            }
        }
        return max;
    }
    
    private static int dfs(int i, int j, List<List<Integer>> matrix){
        if(i<0 || j<0 || i>=matrix.size() || j>=matrix.get(i).size() || matrix.get(i).get(j) == 0){
            return 0;
        }
        int count = 0;
        if(matrix.get(i).get(j) == 1){
            count = 1;
            matrix.get(i).set(j, 0);
            count += dfs(i+1, j, matrix);
            count += dfs(i, j+1, matrix);
            count += dfs(i-1, j, matrix);
            count += dfs(i, j-1, matrix);
            count += dfs(i+1, j+1, matrix);
            count += dfs(i+1, j-1, matrix);
            count += dfs(i-1, j+1, matrix);
            count += dfs(i-1, j-1, matrix);
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
