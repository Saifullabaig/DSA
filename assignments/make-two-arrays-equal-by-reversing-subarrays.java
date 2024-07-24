class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[10001];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
            count[target[i]]--;
        }
        for(int i=0;i<1001;i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }
}
//https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/