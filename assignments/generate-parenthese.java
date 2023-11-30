class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        solve(0, 0, n, res, temp);
        return res;
    }
    void solve(int openCount, int closeCount, int n, List<String> res, StringBuilder temp){
        if(openCount == closeCount && openCount == n){
            res.add(temp.toString());
            return;
        }
        if(openCount < n){
            temp.append('(');
            solve(openCount+1, closeCount, n, res, temp);
            temp.deleteCharAt(temp.length()-1);
        }
        if(closeCount < openCount){
            temp.append(')');
            solve(openCount, closeCount+1, n, res, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
//https://leetcode.com/problems/generate-parentheses/