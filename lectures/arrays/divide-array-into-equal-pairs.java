class Solution {
    public boolean divideArray(int[] nums) {
        int[] temp = new int[1000];
        for(int num:nums){
            temp[num]++;
        }
        for(int i=0;i<temp.length;i++){
            if(temp[i]%2!=0){
                return false;
            }
        }
        return true;
    }
}
//https://leetcode.com/problems/divide-array-into-equal-pairs/