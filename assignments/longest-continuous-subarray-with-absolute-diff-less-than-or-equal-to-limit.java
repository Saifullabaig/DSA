class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int j =0, i;
        for(i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.lastKey() - map.firstKey() > limit){
                map.put(nums[j], map.get(nums[j]) - 1);
                if(map.get(nums[j]) == 0) map.remove(nums[j]);
                j++;
            }
        }
        return i-j;
    }
}
//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/