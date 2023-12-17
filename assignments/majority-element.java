class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(count == 0){
                element = nums[i];
                count = 1;
            }
            else if(nums[i] == element){
                count= count+1;
            }else{
                count = count -1;
            }
        }
        count = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == element){
                count +=1;
            }
            if(count > n/2){
                return element;
            }
        }
        return -1;
    }
}
//https://leetcode.com/problems/majority-element/