class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                res[0] = i;
                res[1] = map.get(rem);
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
