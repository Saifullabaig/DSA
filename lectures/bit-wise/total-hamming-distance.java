class Solution {
    public int totalHammingDistance(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            int count1 = 0;
            for (int j = 0; j < n; j++) {
                if ((nums[j] & 1) == 1)
                    count1++;
                
                nums[j] >>= 1;
            }
            int count0 =  n-count1;
            ans += count0 * count1;
        }
        
        return (int) ans;
    }
}
//https://leetcode.com/problems/total-hamming-distance/