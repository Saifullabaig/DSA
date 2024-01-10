class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return 1;
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int num: nums){
            if(!set.contains(num-1)){
                int temp = num;
                int count = 1;
                while(set.contains(temp+1)){
                    temp += 1;
                    count += 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
//https://leetcode.com/problems/longest-consecutive-sequence/