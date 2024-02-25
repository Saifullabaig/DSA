class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        find(0, nums, ans, new ArrayList<Integer>());
        return ans;
    }
    void find(int ind, int[] nums, List<List<Integer>> ans, ArrayList<Integer> ds){
        ans.add(new ArrayList<>(ds));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            find(i+1, nums, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
}
//https://leetcode.com/problems/subsets-ii/description/