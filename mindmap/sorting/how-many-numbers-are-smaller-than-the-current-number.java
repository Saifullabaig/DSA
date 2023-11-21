class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] snums = Arrays.copyOf(nums, n);
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(snums);
        for(int i=n-1;i>=0;i--){
            map.put(snums[i],i);
        }
        for(int i=0;i<n;i++){
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}
//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/