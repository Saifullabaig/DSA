class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] arr: grid){
            int n = arr.length;
            int pos = searchNegative(arr);
            if(pos != -1){
                count += n-pos;
            }
        }
        return count;
    }
    int searchNegative(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]<0){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/