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
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
    // Write your code here
        int x = 100;
        int n = arr.size();
        Set<Integer> indexes = new HashSet<>();
        List<StringBuilder> strings = new ArrayList<>();
        for(int i=0;i<=x;i++)
        {
            strings.add(new StringBuilder());
        }
        for(int i=0;i<n;i++){
            String indexString = arr.get(i).get(0);
            String letter = arr.get(i).get(1);
            int index = Integer.parseInt(indexString);
            
            if(i<n/2){
                letter = "-";
            }
            strings.get(index).append(letter + " ");
            
            indexes.add(index);
        }
        for(int index: indexes){
            System.out.print(strings.get(index).toString());
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}
