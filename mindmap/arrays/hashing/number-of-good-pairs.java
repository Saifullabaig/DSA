class Solution {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            res += map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return res;
    }
}
//https://leetcode.com/problems/number-of-good-pairs/