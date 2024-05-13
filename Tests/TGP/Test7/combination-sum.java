
class Solution {
 public List<List<Integer>> combinationSum(int[] nums, int target) { 
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, target, ans, new ArrayList<>());
        return ans;
  }
  void dfs(int i, int[] nums, int target, List<List<Integer>> ans, List<Integer> ds){
    if(i==nums.length){
      if(target == 0){
        ans.add(new ArrayList<>(ds));
      }
      return;
    }
    if(nums[i]<=target){
      ds.add(nums[i]);
      dfs(i, nums, target-nums[i], ans, ds);
      ds.remove(ds.size()-1);
    }
    dfs(i+1, nums, target, ans, ds);
    
  }
}