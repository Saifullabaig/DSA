class Solution {
    public int addDigits(int num) {
           return helper(num);
    }

    private int helper(int num){
        if(String.valueOf(num).length() < 2){
            return num;
        }
        int sum = 0;
        while(num!=0){
            sum+=num%10;
            num = num/10;
        }
        return helper(sum);
    }
}
//https://leetcode.com/problems/add-digits/