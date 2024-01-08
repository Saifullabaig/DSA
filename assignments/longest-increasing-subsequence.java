class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    int longSubSeq = lis[j] + 1;
                    lis[i] = Math.max(longSubSeq, lis[i]);
                    max = Math.max(longSubSeq, max);
                }
            }
        }
        return max;
    }
}
//https://leetcode.com/problems/longest-increasing-subsequence/