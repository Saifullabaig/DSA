class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)return res;
        subsetUtil(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    void subsetUtil(int[] nums, int index, ArrayList<Integer> ds, List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        subsetUtil(nums, index+1, ds, res);
        ds.remove(ds.size()-1);
        subsetUtil(nums, index+1, ds, res);
    }
}
//https://leetcode.com/problems/subsets/