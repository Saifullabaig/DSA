class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            if(min > num){
                min = num;
            }
            if(max < num){
                max = num;
            }
        }
        int gcd = findGcd(min, max);
        return gcd;
    }
    private int findGcd(int a, int b){
        if(a == 0) return b;
        return findGcd(b%a, a);
    }
}
//https://leetcode.com/problems/find-greatest-common-divisor-of-array/