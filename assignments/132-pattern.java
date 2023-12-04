class Solution {
    public boolean find132pattern(int[] nums) {
        int secondMax = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            if(secondMax>nums[i]) return true;
            while(!st.isEmpty() && st.peek()<nums[i]){
                secondMax = Math.max(secondMax, st.pop());
            }
            st.push(nums[i]);
        }
        return false;
    }
}
//https://leetcode.com/problems/132-pattern/