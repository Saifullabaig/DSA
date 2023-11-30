class Solution {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            res += map.getOrDefault(num-k, 0);
            res += map.getOrDefault(num+k, 0);
            map.put(num, map.getOrDefault(num,0)+1);
        }
        return res;
    }
}
//https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/