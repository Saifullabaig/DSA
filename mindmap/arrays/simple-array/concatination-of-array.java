class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[2*n];
        for(int i=0;i<n;i++){
            result[i] = nums[i];
        }
        int val = 0;
        for(int j=n;j<2*n;j++){
            result[j] = nums[val++];
        }
        return result;
    }
}