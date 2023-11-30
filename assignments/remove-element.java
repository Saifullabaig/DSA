class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0] == val ? 0 : 1;
        int left = 0;
        int right = nums.length;
        while(left<right){
            if(nums[left] == val){
                swap(nums, left, right-1);
                right--;
            }
            else{
                left++;
            }
        }
        return right;
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//https://leetcode.com/problems/remove-element/