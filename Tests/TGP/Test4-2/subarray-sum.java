import java.util.*;
class Solution {
    public int sumOfMins(int[] arr) {
      int sum = 0;
      for(int i =0;i<arr.length;i++){
        for(int j =i;j<arr.length;j++){
          int mini = Integer.MAX_VALUE;
          for(int k = i;k<=j;k++){
            mini = Math.min(mini, arr[k]);
          }
          sum+=mini;
        }
      }
      return sum;
    }
}
