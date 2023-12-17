class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int allSum = n*(n+1)/2;
        int givenSum = 0;
        for(int num: nums){
            givenSum += num;
        }
        return allSum - givenSum;
    }
}
//https://leetcode.com/problems/missing-number/