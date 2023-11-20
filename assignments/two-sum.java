class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)){
                res[0] = i;
                res[1] = map.get(rem);
                return res;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
}