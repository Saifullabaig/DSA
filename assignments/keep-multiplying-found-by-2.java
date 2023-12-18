class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        for(int i=0;i<n;i++){
            if(!set.contains(original)){
                break;
            }
            original = original * 2;
        }
        return original;
    }
}
//https://leetcode.com/problems/keep-multiplying-found-values-by-two/