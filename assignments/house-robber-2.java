class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i != 0) temp1.add(nums[i]);
            if(i!=n-1) temp2.add(nums[i]);
        }
        return Math.max(find(temp1), find(temp2));
    }
    private int find(List<Integer> nums){
        int prev1= nums.get(0);
        int prev2 = 0;
        for(int i=1;i<nums.size();i++){
            int pick = nums.get(i);
            if(i>1) pick+=prev2;
            int notPick = 0 + prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
//https://leetcode.com/problems/house-robber-ii/