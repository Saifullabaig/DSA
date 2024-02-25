class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        find(0, nums, ans);
        return ans;
    }
    void find(int ind, int[] nums, List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
        }
        for(int i=ind;i<nums.length;i++){
            swap(i, ind, nums);
            find(ind+1, nums, ans);
            swap(i, ind, nums);
        }
    }
    void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//https://leetcode.com/problems/permutations/