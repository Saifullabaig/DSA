class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == 0) return "0";
        Stack<Character> st = new Stack<>();    
        int i =0;
        while(i<num.length()){
            while(k>0 && !st.isEmpty() && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }

        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.toString().startsWith("0")){
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
//https://leetcode.com/problems/remove-k-digits/