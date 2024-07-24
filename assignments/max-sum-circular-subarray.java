class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxStraightSum = Integer.MIN_VALUE;
        int minStraightSum = Integer.MAX_VALUE;
        int tempMaxSum = 0, tempMinSum = 0;
        int arraySum = 0;
        for(int i=0;i<n;i++){
            arraySum += nums[i];
            tempMaxSum += nums[i];
            maxStraightSum = maxStraightSum < tempMaxSum ? tempMaxSum : maxStraightSum;
            tempMaxSum = tempMaxSum < 0 ? 0 : tempMaxSum;
            tempMinSum += nums[i];
            minStraightSum = minStraightSum > tempMinSum ? tempMinSum : minStraightSum;
            tempMinSum = tempMinSum > 0 ? 0 : tempMinSum;
        }
        if(arraySum == minStraightSum){
            return maxStraightSum;
        }
        return Math.max(maxStraightSum, (arraySum - minStraightSum));
    }
}
//https://leetcode.com/problems/maximum-sum-circular-subarray/description/