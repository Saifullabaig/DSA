class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int res1 = -1, res2 = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                res1 = mid;
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }
        start = 0;
        end = nums.length - 1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                res2 = mid;
                start = mid+1;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }
        return new int[]{res1, res2};
    }
}
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/