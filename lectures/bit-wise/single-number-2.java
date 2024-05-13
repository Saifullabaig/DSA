class Solution {
    public int singleNumber(int[] nums) {
       long ans = 0;
        int n = nums.length;
        
        for (int i = 0; i < 32; i++) {
            int count = 0;
            
            for (int j = 0; j < n; j++) {
                if ((nums[j] & 1) == 1)
                    count++;
                
                nums[j] >>= 1;
            }
            
            if (count % 3 != 0) {
                ans = ans + (1L << i);
            }
        }
        
        return (int) ans;
    }
}
//https://leetcode.com/problems/single-number-ii/