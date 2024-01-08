class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] s = path.split("/");
        for(int i=0;i<s.length;i++){
            if(!st.isEmpty() && s[i].equals("..")) st.pop();
            else if(!s[i].equals("") && !s[i].equals(".") && !s[i].equals("..")) st.push(s[i]);
        }

        if(st.isEmpty()){
            return "/";
        }
        while(!st.isEmpty()){
            res.insert(0, st.pop()).insert(0, "/");
        }
        return res.toString();
    }
}
//https://leetcode.com/problems/simplify-path/