class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        int mismatch = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '['){
                st.push('[');
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }else{
                    mismatch++;
                }
            }
        }
        return (mismatch + 1)/2;
    }
}
//https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/