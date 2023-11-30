class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if(map.size() == k){
            max = sum;
        }
        int n = nums.length;
        int left = 0;
        for(int i=k;i<n;i++){
            sum -=(long)nums[left];
            sum +=(long)nums[i];

            map.put(nums[left], map.get(nums[left])-1);
            if(map.get(nums[left]) == 0){
                map.remove(nums[left]);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.size() == k){
                max = Math.max(max, sum);
            }
            left++;
        }
        return max;

    }
}
//https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/