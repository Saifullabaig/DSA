class Solution {
    public int minimumSum(int num) {
        int[] digits = new int[4];
        int cur = 0;
        while(num>0){
            digits[cur] = num%10;
            num = num/10;
            cur++;
        }
        Arrays.sort(digits);
        int num1 = digits[0] * 10 + digits[2];
        int num2 = digits[1] * 10 + digits[3];
        return num1 + num2;
    }
}
//https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits