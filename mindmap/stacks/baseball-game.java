class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String s: operations){
            if(s.equals("+")){
                int x = st.pop();
                int y = st.pop();
                int z = x + y;
                st.push(y);
                st.push(x);
                st.push(z);
            }
            else if(s.equals("D")){
                st.push(st.peek() * 2);
            }else if(s.equals("C")){
                st.pop();
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        int ans = 0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}
//https://leetcode.com/problems/baseball-game/