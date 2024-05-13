class Solution {
    public int lis(int[] arr, int n) {
      // write your code here 
      int[] lis  = new int[n];
      Arrays.fill(lis, 1);
      int maxi = 1;
      for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
          if(arr[i] > arr[j]){
            int longestSubSeq = lis[j] + 1;
            lis[i] = Math.max(longestSubSeq, lis[i]);
            maxi = Math.max(maxi, longestSubSeq);
          }
        }
      }
      return maxi;

    }
}