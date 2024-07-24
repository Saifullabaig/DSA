import java.io.*;
import java.util.*;

class Solution {
  
  static double findGrantsCap(double[] grantsArray, double newBudget) {
    // your code goes here
    if(grantsArray == null || newBudget == 0){
      return 0;
    }
    int len = grantsArray.length;
    double prefixSum = 0.0;
    Arrays.sort(grantsArray); // 2, 50, 100, 120, 1000
    
    for(int i=0;i<len;i++){
      double curr = grantsArray[i];
      double available = newBudget - prefixSum; // 188
      int numsLeft = len-i;  // 4
      
      if(curr*numsLeft > available){
        return available/numsLeft; // 188 / 4  = 47
      }
      prefixSum += curr;
    }
    return grantsArray[len-1];
  }

  public static void main(String[] args) {

  }

}
