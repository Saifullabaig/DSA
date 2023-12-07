class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long mid = 0;
        long ans = 0;
        while(left<=right){
            mid = left + (right-left)/2;
            long sqrt = mid * mid;
            if(sqrt == x){
                return (int) mid;
            }
            else if(sqrt < x){
                left = mid + 1;
                ans = mid;
            }else{
                right = mid - 1;
            }
        }
        return (int) ans;
    }
}
//https://leetcode.com/problems/sqrtx/