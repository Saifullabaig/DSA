class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxi = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                count++;
                if(count>maxi)maxi = count;
            }else if(c == ')'){
                count--;
            }
        } 
        return maxi;
    }
}
//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/