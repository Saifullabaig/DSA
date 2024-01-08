class Solution {
    public class Pair{
        char ch;
        int cnt;
        Pair(char ch, int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }
    public String removeDuplicates(String s, int k) {
        if(s == null || s.length() < k){
            return s;
        }
        Stack<Pair> st = new Stack<>();
        for(Character c: s.toCharArray()){
            if(!st.isEmpty() && st.peek().ch == c){
                st.peek().cnt++;
                if(st.peek().cnt == k){
                    st.pop();
                }
            }else{
                st.push(new Pair(c, 1));
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            Pair p = st.pop();
            for(int i=0;i<p.cnt;i++){
                res.append(p.ch);
            }
        }
        return res.reverse().toString();
    }
}
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/